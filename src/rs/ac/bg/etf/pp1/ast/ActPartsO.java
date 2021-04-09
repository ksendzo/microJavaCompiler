// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class ActPartsO extends ActPartsOpt {

    private ActParts ActParts;

    public ActPartsO (ActParts ActParts) {
        this.ActParts=ActParts;
        if(ActParts!=null) ActParts.setParent(this);
    }

    public ActParts getActParts() {
        return ActParts;
    }

    public void setActParts(ActParts ActParts) {
        this.ActParts=ActParts;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParts!=null) ActParts.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParts!=null) ActParts.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParts!=null) ActParts.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActPartsO(\n");

        if(ActParts!=null)
            buffer.append(ActParts.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActPartsO]");
        return buffer.toString();
    }
}
