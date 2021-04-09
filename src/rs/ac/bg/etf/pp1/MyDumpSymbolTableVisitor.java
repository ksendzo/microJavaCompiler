package rs.ac.bg.etf.pp1;

import java.util.HashMap;

import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class MyDumpSymbolTableVisitor extends SymbolTableVisitor {
	
	protected StringBuilder output = new StringBuilder();
	protected final String indent = "   ";
	protected StringBuilder currentIndent = new StringBuilder();
	
	private HashMap<Struct, String> typeNameMap = new HashMap<Struct, String>();
	
	protected void nextIndentationLevel() {
		currentIndent.append(indent);
	}
	
	protected void previousIndentationLevel() {
		if (currentIndent.length() > 0)
			currentIndent.setLength(currentIndent.length()-indent.length());
	}
		
	

	@Override
	public void visitObjNode(Obj objToVisit) {
		//output.append("[");
		switch (objToVisit.getKind()) {
		case Obj.Con:  output.append("Con "); break;
		case Obj.Var:  output.append("Var "); break;
		case Obj.Type: output.append("Type "); break;
		case Obj.Meth: output.append("Meth "); break;
		case Obj.Fld:  output.append("Fld "); break;
		case Obj.Prog: output.append("Prog "); break;
		}
		
		output.append(objToVisit.getName());
		output.append(": ");
		
		if(Obj.Type == objToVisit.getKind())
			typeNameMap.put(objToVisit.getType(), objToVisit.getName());
		
//		if ((Obj.Var == objToVisit.getKind()) && "this".equalsIgnoreCase(objToVisit.getName()) 
//		|| (Obj.Fld == objToVisit.getKind()) && "TVF".equals(objToVisit.getName()))
//			output.append("");
//		else
//			objToVisit.getType().accept(this);
		
		if(Obj.Var == objToVisit.getKind() || Obj.Fld == objToVisit.getKind() || Obj.Con == objToVisit.getKind() || Obj.Meth == objToVisit.getKind())
			getStructName(objToVisit.getType());
		
		if(Obj.Type == objToVisit.getKind()) 
			output.append("newType");
			
		
		output.append(", ");
		output.append(objToVisit.getAdr());
		output.append(", ");
		output.append(objToVisit.getLevel() + " ");
				
		if (objToVisit.getKind() == Obj.Prog || objToVisit.getKind() == Obj.Meth || objToVisit.getKind() == Obj.Type && objToVisit.getType().getKind() == Struct.Class) {
			output.append("\n");
			nextIndentationLevel();
		}
		

		for (Obj o : objToVisit.getLocalSymbols()) {
			output.append(currentIndent.toString());
			o.accept(this);
			output.append("\n");
		}
		
		if(objToVisit.getKind() == Obj.Type && objToVisit.getType().getKind() == Struct.Class) 
			for (Obj o : objToVisit.getType().getMembers()) {
				output.append(currentIndent.toString());
				o.accept(this);
				if(o.getKind() == Obj.Fld)
					output.append("\n");
			}
		
		if (objToVisit.getKind() == Obj.Prog || objToVisit.getKind() == Obj.Meth || objToVisit.getKind() == Obj.Type && objToVisit.getType().getKind() == Struct.Class) 
			previousIndentationLevel();

		//output.append("]");
		

	}

	@Override
	public void visitScopeNode(Scope scope) {
		for (Obj o : scope.values()) {
			o.accept(this);
			output.append("\n");
		}
	}

	private void getStructName(Struct structToVisit) {
		switch (structToVisit.getKind()) {
		case Struct.None:
			output.append("void");
			break;
//		case Struct.Int:
//			output.append("int");
//			break;
//		case Struct.Char:
//			output.append("char");
//			break;
//		case Struct.Bool:
//			output.append("bool");
//			break;
		case Struct.Array:
			getStructName(structToVisit.getElemType());
			output.append("[]");
			break;
//		case Struct.Class:
//			output.append("class");
//			break;
		default: output.append(typeNameMap.get(structToVisit));
				break;
		}
	}
	
	@Override
	public void visitStructNode(Struct structToVisit) {
		getStructName(structToVisit);
	}

	@Override
	public String getOutput() {
		return output.toString();
	}

}
