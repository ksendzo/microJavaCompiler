// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class CondTer extends CondTernary {

    private Ternary Ternary;

    public CondTer (Ternary Ternary) {
        this.Ternary=Ternary;
        if(Ternary!=null) Ternary.setParent(this);
    }

    public Ternary getTernary() {
        return Ternary;
    }

    public void setTernary(Ternary Ternary) {
        this.Ternary=Ternary;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Ternary!=null) Ternary.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Ternary!=null) Ternary.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Ternary!=null) Ternary.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTer(\n");

        if(Ternary!=null)
            buffer.append(Ternary.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTer]");
        return buffer.toString();
    }
}
