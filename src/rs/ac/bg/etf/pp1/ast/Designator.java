// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private DesigName DesigName;
    private DesigAdditional DesigAdditional;

    public Designator (DesigName DesigName, DesigAdditional DesigAdditional) {
        this.DesigName=DesigName;
        if(DesigName!=null) DesigName.setParent(this);
        this.DesigAdditional=DesigAdditional;
        if(DesigAdditional!=null) DesigAdditional.setParent(this);
    }

    public DesigName getDesigName() {
        return DesigName;
    }

    public void setDesigName(DesigName DesigName) {
        this.DesigName=DesigName;
    }

    public DesigAdditional getDesigAdditional() {
        return DesigAdditional;
    }

    public void setDesigAdditional(DesigAdditional DesigAdditional) {
        this.DesigAdditional=DesigAdditional;
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
        if(DesigName!=null) DesigName.accept(visitor);
        if(DesigAdditional!=null) DesigAdditional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesigName!=null) DesigName.traverseTopDown(visitor);
        if(DesigAdditional!=null) DesigAdditional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesigName!=null) DesigName.traverseBottomUp(visitor);
        if(DesigAdditional!=null) DesigAdditional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        if(DesigName!=null)
            buffer.append(DesigName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesigAdditional!=null)
            buffer.append(DesigAdditional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator]");
        return buffer.toString();
    }
}
