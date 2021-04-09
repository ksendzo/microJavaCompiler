// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class CondCond extends CondTernary {

    private Condition Condition;

    public CondCond (Condition Condition) {
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Condition!=null) Condition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondCond(\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondCond]");
        return buffer.toString();
    }
}
