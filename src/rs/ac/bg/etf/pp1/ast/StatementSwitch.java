// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class StatementSwitch extends Matched {

    private SwitchStart SwitchStart;
    private Cases Cases;

    public StatementSwitch (SwitchStart SwitchStart, Cases Cases) {
        this.SwitchStart=SwitchStart;
        if(SwitchStart!=null) SwitchStart.setParent(this);
        this.Cases=Cases;
        if(Cases!=null) Cases.setParent(this);
    }

    public SwitchStart getSwitchStart() {
        return SwitchStart;
    }

    public void setSwitchStart(SwitchStart SwitchStart) {
        this.SwitchStart=SwitchStart;
    }

    public Cases getCases() {
        return Cases;
    }

    public void setCases(Cases Cases) {
        this.Cases=Cases;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SwitchStart!=null) SwitchStart.accept(visitor);
        if(Cases!=null) Cases.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SwitchStart!=null) SwitchStart.traverseTopDown(visitor);
        if(Cases!=null) Cases.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SwitchStart!=null) SwitchStart.traverseBottomUp(visitor);
        if(Cases!=null) Cases.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementSwitch(\n");

        if(SwitchStart!=null)
            buffer.append(SwitchStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Cases!=null)
            buffer.append(Cases.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementSwitch]");
        return buffer.toString();
    }
}
