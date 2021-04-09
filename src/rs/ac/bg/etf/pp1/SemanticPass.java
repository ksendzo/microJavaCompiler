package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;

//import com.sun.org.apache.bcel.internal.classfile.ParameterAnnotationEntry;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;
//import sun.rmi.transport.ObjectTable;


public class SemanticPass extends VisitorAdaptor{
/*
	int printCallCount = 0;
	int varDeclCount = 0; */
	Obj currentMethod = null;
	Obj currentClass = null;
	Obj currentExtendedClass = null;
	private boolean fieldDecl = false;
	Struct currentType = null;
	boolean errorDetected = false;
	int formalParamCnt = 0;
	int nVars;
	Collection<Obj> actPartsRequired; 
	ArrayList<Struct> actPartsPassed;
	
	Logger log = Logger.getLogger(getClass());
	private boolean isArray = false;
	private boolean inClass = false;
	private boolean inDoWhile = false;
	private boolean inSwitch = false;
	
	private int breakCnt = 0;
	private int continueCnt = 0;
	
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}
	
	public void report_info(String message, SyntaxNode info) {
		//SyntaxNode iinfo = (SyntaxNode.)
		
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public boolean passed(){
    	return !errorDetected;
    }

/*	public void visit(VarDecl vardecl){
		varDeclCount++;
	}
	
    public void visit(PrintStmt print) {
		printCallCount++;
	} */

	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
		MyTab.tempHelp = Tab.insert(Obj.Var, "#", Tab.intType);
		//System.out.println("progName");
	}
	
	public void visit(Program program) {
		nVars = Tab.currentScope.getnVars();
		
		
		Obj mainMeth = Tab.find("main");
		if(mainMeth != Tab.noObj  
			&&	mainMeth.getKind() == Obj.Meth 
			&&	mainMeth.getType() == Tab.noType
			&&	mainMeth.getLevel() == 0) 
			report_info("postoji ispravan main", program);
		else
			report_error("ne postoji void main() globalna funkcija", program);
		
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
		//System.out.println("program");
	}
	
	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if(typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola!", null);
			type.struct = Tab.noType;
		} else {
			if(Obj.Type == typeNode.getKind()) {
				currentType = typeNode.getType();
				type.struct = currentType;
				//report_info("tip = " + type.getTypeName(), type);
			}
			else {
				report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", null);
				type.struct = Tab.noType;
			}
		}
	}
	
	public void visit(TVoid type) {
		type.struct = Tab.noType;
		currentType = Tab.noType;
	}
	
	public void visit(MethodTypeName methodTypeName) {
		currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethName(), currentType);
		methodTypeName.obj = currentMethod; // Zasto ovo radim?
		Tab.openScope();
		if(inClass) {
			Tab.insert(Obj.Var, "this", currentClass.getType());
			formalParamCnt++;
		}
		//report_info("Obradjuje se funkcija " + methodTypeName.getMethName(), methodTypeName);
	}
	
	public void visit(MethodDec methodDec) {
		//if(!returnFound && currentMethod.getType() != Tab.noType) {
			
		//}
//		if(inClass )
//			formalParamCnt++;
		//if(inClass)
			//fieldDecl = false;
			
		currentMethod.setLevel(formalParamCnt);
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		methodDec.obj = currentMethod;
		//returnFound = false;
		currentMethod = null;
		formalParamCnt = 0;
	}
	
	public void visit(FormalPar formalPar) {
		Struct type = formalPar.getType().struct;
		if(isArray) 
			type = new Struct(Struct.Array, type);
		Obj elem = Tab.insert(Obj.Var, formalPar.getFormalParamName(), type);
		formalParamCnt++;
		isArray = false;
	}
	
	public void visit(ClassName className) {
		currentClass = Tab.insert(Obj.Type, className.getClassName(), new Struct(Struct.Class));
		className.obj = currentClass;
		Tab.openScope();
		Tab.insert(Obj.Fld, "TVF", className.obj.getType());
		fieldDecl = true;
		inClass = true;
	}
	
	public void visit(Extends ext) {
		Obj parent = Tab.find(ext.getType().getTypeName());
		// proveri da li postoji
		
		if(parent == Tab.noObj || parent.getType().getKind() != Struct.Class)
			report_error("Greska: ne postoji klasa " + ext.getType().getTypeName(), ext);
		
		currentExtendedClass = parent;
		for(Obj o : currentExtendedClass.getType().getMembers())
			if(o.getKind() == Obj.Fld)
				Tab.insert(Obj.Fld, o.getName(), o.getType());
	}
	
	public void visit(ClassDecls classDecls) { 
		Struct parent = (classDecls.getOptionalExtends() instanceof NoExtends)? Tab.noType: ((Extends)classDecls.getOptionalExtends()).getType().struct;
		
		if (parent != Tab.noType) {
			Obj parentO = Tab.find(((Extends)classDecls.getOptionalExtends()).getType().getTypeName());
			// proveri da li postoji
			
			for(Obj o : parentO.getType().getMembers())
				if(o.getKind() == Obj.Meth) {
					Obj met = Tab.currentScope.findSymbol(o.getName());
					if(met == null) { // kopiraj metodu
						Obj m = Tab.insert(Obj.Meth, o.getName(), o.getType());
						Tab.openScope();
						for(Obj om: o.getLocalSymbols()) {
							Struct t;
							if(om.getName() == "this")
								t = currentClass.getType();
							else 
								t = om.getType();
							Tab.insert(om.getKind(), om.getName(), t);
						}
						m.setAdr(-1);
						Tab.chainLocalSymbols(m);
						Tab.closeScope();
						m.setLevel(o.getLevel());
					}
				
				}
		}
		
		currentClass.getType().setElementType(parent);
		currentClass.getType().setMembers(Tab.currentScope().getLocals());
		Tab.chainLocalSymbols(currentClass.getType());
		Tab.closeScope();
		currentClass = null;
		currentExtendedClass = null;
		inClass = false;
		//fieldDecl = false;
	}
	
	public void visit(NoFieldDecl noFieldDecl) {
		fieldDecl = false;
	}
	
	public void visit(ConstType constType) {
		currentType = constType.getType().struct;
		if(currentType != Tab.intType && currentType != Tab.charType && currentType != MyTab.boolType)
			report_error("Greska: const mora biti  tipa int|char|bool", constType);
	}
	
	public void visit(ConstDecls constDecls) { // zavrsen red
		currentType = null;
	}
	
	public void visit(ConstDeclaration constDeclar) { // ime i vrednost konstante
		if(dozvoljenoDefinisanje(constDeclar.getConstName(), constDeclar))
			if(constDeclar.getConstVal().struct == currentType) 
				constDeclar.obj = Tab.insert(Obj.Con, constDeclar.getConstName(), currentType);
			else 
				report_error("Greska: losi tipovi definisanja konstante", constDeclar);
		
	}
	
	public void visit(NumConst numConst) {
		numConst.struct = Tab.intType;
	}
	
	public void visit(CharConst charConst) {
		charConst.struct = Tab.charType;
	}
	
	public void visit(BoolConst boolConst) {
		boolConst.struct = MyTab.boolType; 
	}
	
	
	public void visit(VarType varType) {
		currentType = varType.getType().struct;
	}
	
	public void visit(VarDeclaration varDeclar) {
		// proveravam da li je ime vec u tabeli
		if(dozvoljenoDefinisanje(varDeclar.getVarName(), varDeclar)) {
			//ubaci promenljivu u tabelu
			int kind;
			if(inClass && fieldDecl)
				kind = Obj.Fld;
			else
				kind = Obj.Var;
			if(isArray) {
				varDeclar.obj = Tab.insert(kind, varDeclar.getVarName(), new Struct(Struct.Array, currentType));
				isArray = false;
			}
			else
				varDeclar.obj = Tab.insert(kind, varDeclar.getVarName(), currentType);
			
		}
	}
	
	private boolean dozvoljenoDefinisanje(String name,  SyntaxNode info) {
		if(Tab.currentScope.findSymbol(name) == null) 
			return true;
		
		report_error("GRESKA u opsegu vec postoji simbol sa imenom " + name, info);
		return false;
	
	}

	public void visit(Array array) {
		isArray  = true;
	}
	
	
	private boolean checkDesigType(Designator designator) {
		int localKind = designator.obj.getKind();
		if(localKind == Obj.Var || localKind == Obj.Elem || localKind == Obj.Fld) 
			return true;
		return false;
	}
	
	private boolean kompatibilniTipovi(Struct tempL, Struct tempR) {
		if(tempL == Tab.noType && (tempR.getKind() == Struct.Class || tempR.getKind() == Struct.Array))
			return true;
		
		if(tempL.getKind() == Struct.Array && tempR.getKind() == Struct.Array) {
			tempL = tempL.getElemType();
			tempR = tempR.getElemType();
		}
		
		
		if(tempL != tempR) {
			while(tempR.getKind() == Struct.Class) {
				tempR = tempR.getElemType();
				if(tempR == tempL)
					return true;
			}
			
			return false;
		}
		return true;
	}
	
	public void visit(DesigAssign desigAssign) {
		checkDesigType(desigAssign.getDesignator()); // dodaj if
		
		Struct tempL = desigAssign.getDesignator().obj.getType();
		Struct tempR = desigAssign.getExpr().struct;
		
		if(!kompatibilniTipovi(tempL, tempR))
			report_error("Greska: losi tipovi dodele", desigAssign);
		
				
	}
	
	private Obj dodajExtMethodAkoPostoji(String name) {
		Obj retObj = Tab.noObj;
		if(currentClass != null && currentExtendedClass != null) {
			Collection<Obj> members = currentExtendedClass.getType().getMembers();
			for(Obj elem: members) {
				if(elem.getName().equals(name))
					retObj = elem;
			}
		}
		return retObj;
	}
	
	public void visit(DesigName desigName) {
		desigName.obj = Tab.find(desigName.getDesigName());
		
		if(desigName.obj == Tab.noObj)
			desigName.obj = dodajExtMethodAkoPostoji(desigName.getDesigName());
		
	}
	
	private Obj getFirstLeft(DesigAddit desigAddit) {
		if(desigAddit.getDesigAdditional() instanceof NoDesigAddit) {
			SyntaxNode parent = desigAddit.getParent();
			while(parent instanceof DesigAddit)
				parent = parent.getParent();
			return ((Designator)parent).getDesigName().obj;
		}
		else
			return desigAddit.getDesigAdditional().obj;

	}
	
	public void visit(DesigId desigId) {
		Obj firstLeft = getFirstLeft((DesigAddit)desigId.getParent());
		
		if(firstLeft == Tab.noObj)	// vec je bilo greske
			desigId.obj = Tab.noObj;
		else {
			if(firstLeft.getType().getKind() != Struct.Class) {
				report_error("Greska: designator " + firstLeft.getName() + " nije objekat ", desigId);
			}
			else {	// jeste objekat		
				if(currentClass != null && firstLeft.getType() == currentClass.getType()) { // 
					Obj temp = Tab.currentScope().getOuter().getLocals().searchKey(desigId.getPartName());
					if(temp == null ) {
						desigId.obj = dodajExtMethodAkoPostoji(desigId.getPartName());
						if(desigId.obj == Tab.noObj)
							report_error("Greska: ne postoji polje/metod " + desigId.getPartName(), desigId);
					}
					else 
						desigId.obj = temp;
				}
				else {				
					desigId.obj = Tab.noObj;
					firstLeft.getType().getMembers().forEach(e->{
						if(e.getName().equals(desigId.getPartName())) {
							desigId.obj = e;
							//((DesigAddit)desigId.getParent()).obj = e;
							report_info("pristup polju/metodi " + desigId.getPartName() + " ", desigId);
							return;
						}
					});
					if(desigId.obj == Tab.noObj)
						report_error("Greska: Ne postoji metod/polje ", desigId);
				}
			}
		}
	}
	
	public void visit(Designator desig) {
		Obj temp = desig.getDesigName().obj;

		if(desig.getDesigAdditional() instanceof NoDesigAddit) {
			desig.obj = temp;
			if(desig.obj.getKind() == Obj.Con)
				report_info("Pristup konstanti " + desig.obj.getName(), desig);
			else if(desig.obj.getKind() == Obj.Var)
				report_info("Pristup promenljivoj " + desig.obj.getName(), desig);
			return;
		}
		
		
		if(desig.getDesigAdditional() instanceof NoDesigAddit)
			desig.obj = desig.getDesigName().obj;
		else 
			desig.obj = desig.getDesigAdditional().obj;
	}
	
	public void visit(DesigAddit desigAddit) {
		desigAddit.obj = desigAddit.getDesigParts().obj;
	}
	
	public void visit(DesigArr desigArr) {
		Obj firstLeft = getFirstLeft((DesigAddit)desigArr.getParent());
		
		if(firstLeft == Tab.noObj) 
			desigArr.obj = Tab.noObj;
		else {
			if(desigArr.getExpr().struct != Tab.intType)
				report_error("Greska: u [] mora biti int", desigArr);
			Struct struk;
			
			if(firstLeft.getType().getKind() == Struct.Array) 
				desigArr.obj = new Obj(Obj.Elem, "elem", firstLeft.getType().getElemType());
			else {
				report_error("Greska: " + firstLeft.getName() + " nije niz ", desigArr);
				desigArr.obj = Tab.noObj;
			}
		}
					
	}
	
	public void visit(DesigPlusPlus desigPlusPlus) {
		if(!checkDesigType(desigPlusPlus.getDesignator()) || desigPlusPlus.getDesignator().obj.getType() != Tab.intType) 
			report_error("Greska: plus plus nije var int", desigPlusPlus);
	}
	
	public void visit(DesigMinusMinus desigMinusMinus) {
		if(!checkDesigType(desigMinusMinus.getDesignator()) || desigMinusMinus.getDesignator().obj.getType() != Tab.intType) 
			report_error("Greska: minus minus nije var int", desigMinusMinus);
	}
	
	public void visit(StatementRead statementRead) {
		Designator d = statementRead.getDesignator();
		if(checkDesigType(d)) 
			if(d.obj.getType() == MyTab.intType || d.obj.getType() == MyTab.charType || d.obj.getType() == MyTab.boolType) {
				report_info("read()", statementRead);
				return;
			} 
		report_error("GRESKA read nema dobre parametre", statementRead);
	}	
	
	public void visit(StatementPrint statementPrint) {
		Struct kind = statementPrint.getExpr().struct;
		if(kind != Tab.intType && kind != Tab.charType && kind != MyTab.boolType)
			report_error("Greska: print mora imati int/char/bool", statementPrint);
	}
	
	private boolean sameParts() {
		
		// actParts - trazeni argumenti - Collection<Obj>
		// 
		
		return true;
	}
	
	private boolean checkParams(Designator desig) {
		
		if(actPartsPassed.size() == actPartsRequired.size()) {
			int i = 0;
			for(Obj req: actPartsRequired) {
				if(req.getType() != actPartsPassed.get(i))
					if( !(req.getType().getKind() == Struct.Array && actPartsPassed.get(i).getKind() == Struct.Array)) {
						i = -1; 
						break;
					}
				i++;					
			}
			if(i != -1)
				return true;
		}
		if(actPartsPassed.size() + 1 == actPartsRequired.size()) {
			int i = 0; boolean prvi = true;
			for(Obj req: actPartsRequired) {
				if(prvi) {
					prvi = false;
					continue;
				}
				if(req.getType() != actPartsPassed.get(i))
					if( !(req.getType().getKind() == Struct.Array && actPartsPassed.get(i).getKind() == Struct.Array)) {
						i = -1; 
						break;
					}
				i++;					
			}
			if(i != -1)
				return true;
		}
		
		return false;
		
		
		
		
//		boolean method;
//		if(inClass 
//		||  (!inClass 
//				&& (desig.getDesigAdditional() instanceof NoDesigAddit 
//					|| ((DesigAddit)desig.getDesigAdditional()).getDesigParts() instanceof DesigArr)))
//			method = true;
//		else
//			method = false;
//		
//		int i = 0, j = 0;
//		
//		if(!(actPartsRequired.size() == actPartsPassed.size() && !method || actPartsRequired.size() == actPartsPassed.size() + 1 && method))
//			return false;
//		
//		for(Obj elem: actPartsRequired) {
//			if(method && j == 0)
//				j++;
//			else {
//				if(elem.getType() != actPartsPassed.get(i))
//					return false;
//				i++;
//				j++;
//			}
//		}
//		return true;
	}
	
	public void visit(DesigMethod desigMethod) {
		//Obj localObj = Tab.find(desigMethod.getDesignator().obj.getName());
		
		if(desigMethod.getDesignator().obj.getKind() != Obj.Meth) {
			report_error("ne postoji metoda " + desigMethod.getDesignator().obj.getName(), desigMethod);			
		}
		else {
			actPartsRequired = desigMethod.getDesignator().obj.getLocalSymbols();
			if(!checkParams(desigMethod.getDesignator()))
				report_error("Greska: losi parametri u pozivu metode " + desigMethod.getDesignator().obj.getName(), desigMethod);
			else {
				if(desigMethod.getDesignator().obj.getType().getKind() == Struct.Class || 
						desigMethod.getDesignator().obj.getType().getKind() == Struct.Array)
					report_info("Poziv klasne metode " + desigMethod.getDesignator().obj.getName(), desigMethod);
				else
					report_info("Poziv funkcije " + desigMethod.getDesignator().obj.getName(), desigMethod);
			}	
		}
		actPartsPassed = null;
		actPartsRequired = null;
	}
	
	public void visit(FactorConst factorConst) {
		factorConst.struct = factorConst.getConstVal().struct;
	}
	
	public void visit(FactorNewClass factorNewClass) {
		if (factorNewClass.getType().struct.getKind() != Struct.Class) {
			report_error("nije klasa", factorNewClass);
		}
		else
			report_info("Nov objekat tipa " + factorNewClass.getType().getTypeName() , factorNewClass);
		factorNewClass.struct = factorNewClass.getType().struct;
	}
	
	public void visit(FactorNewArray factorNewArray) {
		Struct s = new Struct(Struct.Array, factorNewArray.getType().struct);
		factorNewArray.struct = s;
		
		if(factorNewArray.getExpr().struct != Tab.intType)
			report_error("Greska: u [] mora stajati int ", factorNewArray);
		
		//report_info("niz tipa ", factorNewArray);
	}
	
	public void visit(FactorExpr factorExpr) {
		factorExpr.struct = factorExpr.getExpr().struct;
	}
	
	public void visit(FactorDes factorDes) {
		factorDes.struct = factorDes.getDesignator().obj.getType();
		if(factorDes.getOptActPartsOpt() instanceof NoOptActParts)
			return;
		if(factorDes.getDesignator().obj.getKind() != Obj.Meth) {
			report_error("Greska: " + factorDes.getDesignator().getDesigName().getDesigName() + " nije funkcija/metoda", factorDes);
			return;
		}

		
		actPartsRequired = factorDes.getDesignator().obj.getLocalSymbols();
		
		if(!checkParams(factorDes.getDesignator()))
			report_error("Greska: losi parametri pri pozivu methode " + factorDes.getDesignator().getDesigName().getDesigName(), factorDes);
		
		factorDes.struct = factorDes.getDesignator().obj.getType();
		
		actPartsRequired = null;
		actPartsPassed = null;
	}
	
	public void visit(OActPO oa) {
		
	}
	
	public void visit(NoActParts na) {
		actPartsPassed = new ArrayList<Struct>();
	}
	
	public void visit(ActPartsC actPart) {
		if(actPartsPassed == null)
			actPartsPassed = new ArrayList<Struct>();
		actPartsPassed.add(actPart.getExpr().struct);
	}
	
	public void visit(ActPartsE actPart) {
		if(actPartsPassed == null)
			actPartsPassed = new ArrayList<Struct>();
		actPartsPassed.add(actPart.getExpr().struct);
	}
	
	
	public void visit(CondCond condCond) {
		condCond.struct = condCond.getCondition().struct;
	//
		if (condCond.struct == MyTab.boolType) {
			report_info("Dobar uslov", condCond);
		}
		else
			report_error("GRESKA los uslov", condCond);
	}
	
	public void visit(CondTer condTer) {
		 condTer.struct = condTer.getTernary().struct;
		 if(condTer.struct != MyTab.boolType)
			 report_error("LOS USLOV", condTer);
		 else
			 report_info("DOBAR USLOV", condTer);
	}
	
	public void visit(ConditionC cond) {
		if(cond.getCondition().struct == MyTab.boolType && cond.getCondTerm().struct == MyTab.boolType)
			cond.struct = MyTab.boolType;
		else
			report_error("LOS TIP USLOVA", cond);
	}
	
	public void visit(ConditionT cond) {
		cond.struct = cond.getCondTerm().struct;
	}
	
	public void visit(CondTermC cond) {
		if(cond.getCondFact().struct == MyTab.boolType && cond.getCondTerm().struct == MyTab.boolType)
			cond.struct = MyTab.boolType;
	}
	
	public void visit(CondTermT cond) {
		cond.struct = cond.getCondFact().struct;
	}
	
	public void visit(CondFactE cond) {
		 cond.struct = cond.getExprNonTer().struct;
		 if(cond.struct != MyTab.boolType)
			 report_error("Greska: nije bool", cond);
	}
	
	public void visit(CondFactR cond) {
		 if(kompatibilniTipovi(cond.getExprNonTer().struct, cond.getExprNonTer1().struct)) //  DA LI SU KOMPATIBILNI I DA LI JE NIZ ILI CLASSS
			if((cond.getExprNonTer().struct.getKind() == Struct.Array || cond.getExprNonTer().struct.getKind() == Struct.Class)
			&& !(cond.getRelOp() instanceof RelOpE || cond.getRelOp() instanceof RelOpD)) {
				report_error("Greska: klasu i niz mogu samo da poredim po jednakosti ",cond);
				cond.struct = Tab.noType;
			}
			else
			 cond.struct = MyTab.boolType;
		 else {
			 report_error("Greska: nisu kompatibilni tipovi", cond);
			 cond.struct = Tab.noType;
		 }
	}
	
	public void visit(ExprT expr) {
		expr.struct = expr.getExprNonTer().struct;
	}
	
	public void visit(ExprCond expr) {
		expr.struct = expr.getTernary().struct;
	}
	
	public void visit(ExprNonT expr) {
		expr.struct = expr.getTerm().struct;
		if(expr.getOptMinus() instanceof OptMin)
			if(expr.struct != Tab.intType) {
				report_error("Greska: expr mora biti tipa int", expr);
				expr.struct = Tab.noType;
			}
		if(!(expr.getAddTerm() instanceof NoAddTerm) && expr.getTerm().struct != Tab.intType) {
			report_error("Greska: sabiranje nije tipa int", expr.getParent());
		}
	}
	
	public void visit(Ternary ternary) {
		ternary.struct = ternary.getExpr().struct;
		if(ternary.getExpr().struct != ternary.getExpr1().struct)
			report_error("Greska: ternarni operatori nisu istog tipa", ternary);
	}
	
	
	public void visit(TermM term) {
		if(term.getTerm().struct != Tab.intType || term.getFactor().struct != Tab.intType)
			report_error("Greska: mnozenje nije tipa int", term);
		term.struct = term.getTerm().struct;
	}
	
	public void visit(TermF term) {
		term.struct = term.getFactor().struct;
	}
	
	public void visit(AddTermA addTerm) {
		addTerm.struct = addTerm.getTerm().struct;
		if((addTerm.getAddTerm() instanceof AddTermA && addTerm.getAddTerm().struct != Tab.intType) || addTerm.getTerm().struct != Tab.intType) {
			report_error("Greska: sabiranje nije tipa int", addTerm.getParent());
			addTerm.struct = Tab.noType;
		}
	}
	
	
	
	public void visit(DoWhile doWhile) {
		inDoWhile = true;
		breakCnt++;
		continueCnt++;
	}
	
	public void visit(StatementDo statementDo) {
		breakCnt--;
		continueCnt--;
		inDoWhile = false;
	}
	
	public void visit(Switch sw) {
		inSwitch = true;
		breakCnt++;
	}
	
	public void visit(StatementSwitch statementSwitch) {
		inSwitch = false;
		breakCnt--;
		
		if(statementSwitch.getSwitchStart().getExpr().struct != Tab.intType)
			report_error("Greska: switch mora biti int tipa", statementSwitch);
		
		
		CounterVisitor cntVisitor = new CounterVisitor();
		statementSwitch.traverseBottomUp(cntVisitor);
		
		if(cntVisitor.getSameCase())
			report_error("Greska: vise case grana ima istu vrednost ", statementSwitch);
		
	}
	
	public void visit(StatementBreak stBreak) {
		if (breakCnt > 0) 
			report_info("ispravan break", stBreak);
		else 
			report_error("los break", stBreak);
	}
	
	public void visit(StatementContinue stContinue) {
		if(continueCnt > 0)
			report_info("ispravan continue", stContinue);
		else 
			report_error("los continnue", stContinue.getParent());
	}
	
	
	public void visit(StatementReturn stmReturn) {
		if(stmReturn.getOptExpr() instanceof NoExpr && currentMethod.getType() != Tab.noType)
			report_error("Greska: metoda nije void potreba je povratna vrednost ", stmReturn);
		if(stmReturn.getOptExpr() instanceof ExprO && !kompatibilniTipovi(((ExprO)stmReturn.getOptExpr()).getExpr().struct, currentMethod.getType()))
			report_error("Greska: povratna vrednost metode i return-a nisu iste ", stmReturn);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
