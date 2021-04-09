package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;
	
	private Stack<Integer> ifStack = new Stack<Integer>();
	private Stack<Integer> elseStack = new Stack<Integer>();
	private Stack<Integer> doWhileStack = new Stack<Integer>();
	private Stack<Integer> ternaryStack = new Stack<Integer>();
	
	
	private Stack<Integer> endSwitchStack = new Stack<Integer>();
	private Stack<Queue<Integer>> caseAdrStack = new Stack<Queue<Integer>>(); // za svaki switch pamti gde je poslednje mesto koje treba zakrpiti
	
	private Stack<List<Integer>> breakStack = new Stack<List<Integer>>();
	private Stack<List<Integer>> continueStack = new Stack<List<Integer>>();
	
	
	private List<Integer> andList = new ArrayList<Integer>();
	private List<Integer> orList = new ArrayList<Integer>();
	
	private static final int inNowhere = 0;
	private static final int inIfCond = 1;
	private static final int inDoWhileBlock = 2;
	private static final int inSwitchBlock = 3;
	
	private Stack<Integer> whereAmI = new Stack<Integer>();
	{ whereAmI.push(inNowhere);}
	
	private List<Obj> myClasses = new ArrayList<Obj>();
	private int staticSizeCnt = 0;
	private HashMap<Struct, Integer> TVF = new HashMap<Struct, Integer>();
	private HashMap<Struct, ArrayList<Integer>> classesAdrToBeFixed = new HashMap<Struct, ArrayList<Integer>>();

	private boolean globalMethDeclar = false;
	
	public int getMainPc(){
		return mainPc;
	}

	
	public void visit(ClassDecls classDecls) {
		Collection<Obj> elements = classDecls.getClassName().obj.getType().getMembers();
		
		elements.forEach(e->{
			if(e.getKind() == Obj.Meth && e.getAdr() == -1) {
				// nadji adresu koda na kojoj se nalazi 
				Collection<Obj> extendsElements = classDecls.getClassName().obj.getType().getElemType().getMembers();
				extendsElements.forEach(ee->{
					if(e.getName().equals(ee.getName()))
						e.setAdr(ee.getAdr());
				});
			}
		});
		
		
		myClasses.add(classDecls.getClassName().obj);
	}
	
	public void visit(VarDeclaration varDeclaration) {
		SyntaxNode sn = varDeclaration.getParent();
		while (sn instanceof VarList || sn instanceof VarListComma)
			sn = sn.getParent();
		if(sn instanceof VarDecls)
			staticSizeCnt++;
	}
	
	private void fixTVF(ArrayList<Integer> ar) {
		if(ar != null)
			ar.forEach(e->{
				Code.put2(e, Code.dataSize);
			});
	}
	
	private void generateTVF() {
		
		myClasses.forEach(e->{ // za svaku klasu
			TVF.put(e.getType(), Code.dataSize);
			fixTVF(classesAdrToBeFixed.get(e.getType()));
			Collection<Obj> myFun = e.getType().getMembers();
			myFun.forEach(f->{
				if(f.getKind() == Obj.Meth) { // za svaku metodu
					String name = f.getName();
					for(int i = 0; i < name.length(); i++) {
						Code.loadConst(name.charAt(i));
						Code.put(Code.putstatic);
						Code.put2(Code.dataSize++);
					}
					Code.loadConst(-1); // kraj imena metode
					Code.put(Code.putstatic);
					Code.put2(Code.dataSize++);
					
					Code.loadConst(f.getAdr()); // adresa metode
					Code.put(Code.putstatic);
					Code.put2(Code.dataSize++);
				}
			});
			Code.loadConst(-2); // kraj tabele 
			Code.put(Code.putstatic);
			Code.put2(Code.dataSize++);
		});
	}
	


	public void visit(MethodTypeName methodTypeName) {
		
		if("main".equalsIgnoreCase(methodTypeName.getMethName())) {
			mainPc = Code.pc;
			generateTVF();
		}
		
		methodTypeName.obj.setAdr(Code.pc);
		
		int formalParamCnt = methodTypeName.obj.getLevel();
		int localCnt = methodTypeName.obj.getLocalSymbols().size();
		
		Code.put(Code.enter);
		Code.put(formalParamCnt);
		Code.put(localCnt);		
	}
	
	public void visit(MethodDec method) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	
	private int constValue(SyntaxNode type) {
		if( type instanceof NumConst)
			return ((NumConst)type).getN1();
		if(type instanceof CharConst)
			return ((CharConst)type).getC1().charAt(1);
		if(type instanceof BoolConst)
			if(((BoolConst)type).getB1().equals("true"))
				return 1;
			else
				return 0;
		return -1;
	}
	
	public void visit(ConstDeclaration cnst) {
		cnst.obj.setAdr(constValue(cnst.getConstVal()));
		Code.load(cnst.obj);
	}
	public void visit(FactorConst cnst) { // za bezimene konstante 5 'a' false
		Obj con = Tab.insert(Obj.Con, "$", cnst.struct);
		con.setAdr(constValue(cnst.getConstVal()));
		Code.load(con);
	}
	
	
	public void visit(DesigAssign desigAssign) {
		// ono sto je u akumulatoru smesta se na trazenu lokaciju
		if(desigAssign.getDesignator().obj.getKind() == Obj.Elem)
			if(desigAssign.getDesignator().obj.getType() == Tab.charType)
				Code.put(Code.bastore);
			else
				Code.put(Code.astore);
		else
			Code.store(desigAssign.getDesignator().obj);
	}
	
	private void checkDesigParent(Designator designator) {
		SyntaxNode parent = designator.getParent();
		//if(designator.getDesigAdditional() instanceof DesigAddit)
			//Code.load(designator.getDesigName().obj);
		//else
		// ako je poziv metode ili dodela vrednosti ne treba mi vrednost designatora
		// u ostalim slucajevima mi treba
		if(!(parent instanceof DesigAssign && designator.getDesigAdditional() instanceof NoDesigAddit) // ako je dodela vrednosti nije mi potrebno da dohvatam vrednost, ali ako ima delove, onda jeste
		&& !(parent instanceof DesigMethod) 
		&& !(parent instanceof FactorDes && ((FactorDes)parent).getOptActPartsOpt() instanceof OActPO) // poziv funkcije u izrazu
		&& !(parent instanceof StatementRead))
			Code.load(designator.obj);
	}
	
	public void visit(Designator designator) {
		//checkDesigParent(designator);		
	}
	
	public void visit(GlobalStart gs) {
		globalMethDeclar = true;
	}
	
	public void visit(DesigName desigName) {
		
		// da li mu fali this
		if(!globalMethDeclar) {
			if(desigName.obj.getKind() == Obj.Fld || desigName.obj.getKind() == Obj.Meth) {
				//Code.put(Code.load);
				Code.put(Code.load_n);
			}
		}
		
		
		// da li je poslednji?
		if(((Designator)desigName.getParent()).getDesigAdditional() instanceof NoDesigAddit) {
			SyntaxNode parent = desigName.getParent().getParent();
			if(!(parent instanceof DesigAssign) // ako je dodela vrednosti nije mi potrebno da dohvatam vrednost, ali ako ima delove, onda jeste
				&& !(parent instanceof DesigMethod) 
				&& !(parent instanceof FactorDes && ((FactorDes)parent).getOptActPartsOpt() instanceof OActPO) // poziv funkcije u izrazu
				&& !(parent instanceof StatementRead))
					Code.load(desigName.obj);
		} else
			Code.load(desigName.obj);
	}
	
	public void visit(DesigId desigId) {
		// da li je poslednji?
		if(desigId.getParent().getParent() instanceof Designator) {
			SyntaxNode desig = desigId.getParent().getParent();
			SyntaxNode parent = desig.getParent();
			if(!(parent instanceof DesigAssign ) // ako je dodela vrednosti nije mi potrebno da dohvatam vrednost, ali ako ima delove, onda jeste
					&& !(parent instanceof DesigMethod) 
					&& !(parent instanceof FactorDes && ((FactorDes)parent).getOptActPartsOpt() instanceof OActPO) // poziv funkcije u izrazu
					&& !(parent instanceof StatementRead))
						Code.load(desigId.obj);
		} else
			Code.load(desigId.obj);			
	}
	
	public void visit(AddTermA addTerm) {
		SyntaxNode op = addTerm.getAddOp();
		if(op instanceof AddOpP)
			Code.put(Code.add);
		if(op instanceof AddOpM)
			Code.put(Code.sub);
	}

	public void visit(StatementPrint stmPrint) {
		if(stmPrint.getExpr().struct == Tab.intType || stmPrint.getExpr().struct == MyTab.boolType) {
			Code.loadConst(5);
			Code.put(Code.print);
		}
		else {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}
	
	public void visit(StatementRead stmRead) {
		Code.put(Code.read);
		Code.store(stmRead.getDesignator().obj);
	}
	
	public void visit(TermM term) {
		SyntaxNode type = term.getMulOp();
		
		if(type instanceof MulOpM)
			Code.put(Code.mul);
		if(type instanceof MulOpD)
			Code.put(Code.div);
		if(type instanceof MulOpMod)
			Code.put(Code.rem);		
	}
	
	public void visit(OptMin neg) {
		//Code.put(Code.neg);
	}
	
	public void visit(ExprNonT expr) {
		if(expr.getOptMinus() instanceof OptMin)
			Code.put(Code.neg);
	}
	
	public void visit(CondFactR cond) {
		SyntaxNode type = cond.getRelOp();
		
		if(type instanceof RelOpE) 
			Code.putFalseJump(Code.eq, 0);
		if(type instanceof RelOpD)
			Code.putFalseJump(Code.ne, 0);
		if(type instanceof RelOpL)
			Code.putFalseJump(Code.lt, 0);
		if(type instanceof RelOpEL)
			Code.putFalseJump(Code.le, 0);
		if(type instanceof RelOpG)
			Code.putFalseJump(Code.gt, 0);
		if(type instanceof RelOpEG)
			Code.putFalseJump(Code.ge, 0);
	}
	
	public void visit(CondFactE cond) {
		Code.put(Code.const_1);
		Code.putFalseJump(Code.eq, 0);
	}
	
	public void visit(If i) {
		whereAmI.push(inIfCond);
	}
	
	public void visit(Else els) {
		
		Code.put(Code.jmp);
		Code.put2(0);
		elseStack.push(Code.pc - 2);
		
		Code.fixup(ifStack.pop());		
	}
	
	
	public void visit(UnmatchedIf unmatchedIf) {
		Code.fixup(ifStack.pop());
	}
	
	public void visit(UnmatchedElse unmatchedElse) {
		Code.fixup(elseStack.pop());
	}
	
	public void visit(StatementIf stmIf) {
		Code.fixup(elseStack.pop());
	}
	
	
	private void condition(int adr) {
		if(whereAmI.peek() == inIfCond) {
			Code.put(Code.jmp);
			Code.put2(0);
			
			ifStack.push(Code.pc - 2);
			
			orList.forEach(o->{
				Code.fixup(o); // postavlja then 
			});
		}
		
		orList.clear();
	}
	
	public void visit(CondCond condTernary) {
		if(condTernary.getParent() instanceof StatementDo)
			condition(doWhileStack.pop());
		condition(0);		
		if(whereAmI.peek() == inIfCond)
			whereAmI.pop();
	}
	
	private void or() {
		Code.put(Code.jmp);
		if(whereAmI.peek() == inDoWhileBlock)
			Code.put2(doWhileStack.peek() -  Code.pc + 1);
		else {
			Code.put2(0); // skakanje na then
			orList.add(Code.pc - 2);
		}
		
		
		andList.forEach(adr->{
			Code.fixup(adr);
		});
		andList.clear();		
	}
	
	public void visit(ConditionT cond) {
		or();
	}
	
	public void visit(ConditionC cond) {
		or();
	}
	
	
	private void and() {
		andList.add(Code.pc - 2);	
	}
	
	public void visit(CondTermC cond) {
		and();
	}
	
	public void visit(CondTermT cond) {
		and();
	}
	
	
	public void visit(DoWhile doWhile) {
		doWhileStack.push(Code.pc);
		whereAmI.push(inDoWhileBlock);
		breakStack.push(new ArrayList<Integer>());
		continueStack.push(new ArrayList<Integer>());
	}
	
	public void visit(While whl) {
		continueStack.pop().forEach(e->{
			Code.fixup(e);
		});
	}
	
	public void visit(StatementDo statementDo) {
		breakStack.pop().forEach(e->{
			Code.fixup(e);
		});
		whereAmI.pop();
	}
	
	public void visit(SwitchStart switchStart) {
		whereAmI.push(inSwitchBlock);
		
		SyntaxNode switchNode = switchStart.getParent();
		
		CounterVisitor cntVisitor = new CounterVisitor();
		switchNode.traverseBottomUp(cntVisitor);
		int caseNumber = cntVisitor.getCaseNumber();
		List<Integer> caseValue = cntVisitor.getCaseValues();
		
		caseAdrStack.push(new LinkedList<Integer>());
		
		Obj temp = new Obj(Obj.Var, "$", Tab.intType);
		Code.store(temp);
		
		for(int i = 0; i < caseNumber; i++) {
			Code.load(temp);
			Code.loadConst(caseValue.get(i));
			Code.putFalseJump(Code.ne, 0);
			caseAdrStack.peek().add(Code.pc - 2);
		}
		
		Code.putJump(0);
		breakStack.add(new ArrayList<Integer>());
		breakStack.peek().add(Code.pc - 2);		
	}
	
	public void visit(Case c) {
		Code.fixup(caseAdrStack.peek().poll());		
	}
	
	public void visit(StatementSwitch stmSwitch) {
		breakStack.pop().forEach(e->{
			Code.fixup(e);
		});
		caseAdrStack.pop();
		whereAmI.pop();
	}
	
	public void visit(StatementBreak stmBreak) {
		Code.putJump(0);
		breakStack.peek().add(Code.pc - 2);
	}
	
	public void visit(StatementContinue stmContinue) {
		Code.putJump(0);
		continueStack.peek().add(Code.pc-2);
	}
	
	public void visit(Question question) {
		Code.putJump(0);
		ternaryStack.push(Code.pc - 2);
		
		orList.forEach(e->{
			Code.fixup(e);
		});
		orList.clear();
	}
	
	public void visit(Doubledot dd) {		
		Code.putJump(0);
		Code.fixup(ternaryStack.pop());
		ternaryStack.push(Code.pc - 2);
	}
	
	public void visit(Ternary ternary) {
		Code.fixup(ternaryStack.pop());
	}
	
	public void visit(DesigAddit desigAdditional) {
		Obj o;
		if(desigAdditional.getParent() instanceof Designator)
			o = ((Designator)desigAdditional.getParent()).obj;
		else
			o = ((DesigAddit)desigAdditional.getParent()).obj;
		
		o.getLocalSymbols().forEach(e->{
			if(desigAdditional.getDesigParts() instanceof DesigId)
				if(e.getName().equals(((DesigId)desigAdditional.getDesigParts()).getPartName())) {
					Code.load(e);
				}
					
		});
		
	}
	
	public void visit(FactorNewClass newClass) {
		Code.put(Code.new_);
		Code.put2(newClass.getType().struct.getNumberOfFields()*4);
		
		//Obj temp = new Obj(Obj.Var, "$", Tab.intType);
		
		Code.put(Code.dup);
		
		//Code.store(temp);
		//Code.load(temp);
		if(TVF.get(newClass.struct) == null) {
			Code.put(Code.const_);
			Code.put4(0);
			if(!classesAdrToBeFixed.containsKey(newClass.struct))
				classesAdrToBeFixed.put(newClass.struct, new ArrayList<Integer>());
			classesAdrToBeFixed.get(newClass.struct).add(Code.pc - 2);
		}
		else
			Code.loadConst(TVF.get(newClass.struct));
		Code.put(Code.putfield);
		Code.put2(0);
		
		//Code.load(temp);
		
		//newClass.getParent()
	}
	
	
	public void visit(FactorNewArray factorNewArray) {
		Code.put(Code.newarray);
		if(factorNewArray.getType().struct == Tab.charType)
			Code.put(0);
		else
			Code.put(1);
	}
	
	public void visit(DesigArr desigArr) {
		// da li je poslednji
		if(desigArr.getParent().getParent() instanceof Designator) {
			SyntaxNode desig = desigArr.getParent().getParent();
			SyntaxNode parent = desig.getParent();
			if(!(parent instanceof DesigAssign ) // ako je dodela vrednosti nije mi potrebno da dohvatam vrednost, ali ako ima delove, onda jeste
					&& !(parent instanceof DesigMethod) 
					&& !(parent instanceof FactorDes && ((FactorDes)parent).getOptActPartsOpt() instanceof OActPO) // poziv funkcije u izrazu
					&& !(parent instanceof StatementRead))
				if(desigArr.obj.getType() == Tab.charType)
					Code.put(Code.baload);
				else
					Code.put(Code.aload);
		} else {
			if(desigArr.obj.getType() == Tab.charType)
				Code.put(Code.baload);
			else
				Code.put(Code.aload);
			if(((DesigAddit)desigArr.getParent()).getParent() instanceof DesigAddit
			&& ((DesigAddit)((DesigAddit)desigArr.getParent()).getParent()).getDesigParts() instanceof DesigId) {
				Code.put(Code.dup);
				Code.store(MyTab.tempHelp);
				
			}
				
		}
		
	}
	
	private Obj predzadnji(Designator desig) {
		if(((DesigAddit)desig.getDesigAdditional()).getDesigAdditional() instanceof NoDesigAddit)
			return desig.getDesigName().obj;
		else
			return ((DesigAddit)desig.getDesigAdditional()).getDesigAdditional().obj;
	}
	
	private void setFunCall(Designator desig) {
		if(desig.getDesigAdditional() instanceof NoDesigAddit) {
			Code.put(Code.call);
			Code.put2(desig.obj.getAdr() - Code.pc + 1);
		} else {
			Obj referenca;
			if(((DesigAddit)desig.getDesigAdditional()).getDesigAdditional() instanceof NoDesigAddit)
				referenca = desig.getDesigName().obj;
			else
				referenca = ((DesigAddit)desig.getDesigAdditional()).getDesigAdditional().obj;
			
			//Code.put(Code.dup);
			Obj prz = predzadnji(desig);
			if(prz.getKind() == Obj.Elem) {
				Code.load(MyTab.tempHelp);
			}
			else
				Code.load(prz);
			
			Code.put(Code.getfield);
			Code.put2(0);
			
			Code.put(Code.invokevirtual);
			String name = desig.obj.getName();
			for(int i = 0; i < name.length(); i++)
				Code.put4(name.charAt(i));
			Code.put4(-1);
		}
	}
	
	public void visit(DesigMethod desigMethod) {
		setFunCall(desigMethod.getDesignator());
		
		if(desigMethod.getDesignator().obj.getType() != Tab.noType)
			Code.put(Code.pop);
		
	}
	
	public void visit(FactorDes factorDes) {
		if(factorDes.getOptActPartsOpt() instanceof OActPO) { // poziv funkcije
			setFunCall(factorDes.getDesignator());
		}
	}
	
	public void visit(DesigPlusPlus plusPlus) {
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.store(plusPlus.getDesignator().obj);
	}
	
	public void visit(DesigMinusMinus minusMinus) {
		Code.put(Code.const_1);
		Code.put(Code.sub);
		Code.store(minusMinus.getDesignator().obj);
	}
	
	
	
	
}
