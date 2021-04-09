// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class VarDeclaration implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private String varName;
    private OptionalArray OptionalArray;

    public VarDeclaration (String varName, OptionalArray OptionalArray) {
        this.varName=varName;
        this.OptionalArray=OptionalArray;
        if(OptionalArray!=null) OptionalArray.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public OptionalArray getOptionalArray() {
        return OptionalArray;
    }

    public void setOptionalArray(OptionalArray OptionalArray) {
        this.OptionalArray=OptionalArray;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalArray!=null) OptionalArray.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalArray!=null) OptionalArray.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalArray!=null) OptionalArray.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclaration(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(OptionalArray!=null)
            buffer.append(OptionalArray.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclaration]");
        return buffer.toString();
    }
}
