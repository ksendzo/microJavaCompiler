package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*; 
import rs.etf.pp1.symboltable.structure.*;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class MyTab extends Tab {
	public static final Struct boolType = new Struct(Struct.Bool);
	public static Obj tempHelp;
	
	public static void myInit() {
		init();
		currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
	}
	
	
	
	public static void dump() {
		System.out.println("=====================SYMBOL TABLE DUMP=========================");
		//if (stv == null)
		MyDumpSymbolTableVisitor stv = new MyDumpSymbolTableVisitor();
		for (Scope s = currentScope; s != null; s = s.getOuter()) {
			s.accept(stv);
		}
		System.out.println(stv.getOutput());
	}
	
	
}
