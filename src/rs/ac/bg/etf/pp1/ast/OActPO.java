// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class OActPO extends OptActPartsOpt {

    private ActPartsOpt ActPartsOpt;

    public OActPO (ActPartsOpt ActPartsOpt) {
        this.ActPartsOpt=ActPartsOpt;
        if(ActPartsOpt!=null) ActPartsOpt.setParent(this);
    }

    public ActPartsOpt getActPartsOpt() {
        return ActPartsOpt;
    }

    public void setActPartsOpt(ActPartsOpt ActPartsOpt) {
        this.ActPartsOpt=ActPartsOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActPartsOpt!=null) ActPartsOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActPartsOpt!=null) ActPartsOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActPartsOpt!=null) ActPartsOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OActPO(\n");

        if(ActPartsOpt!=null)
            buffer.append(ActPartsOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OActPO]");
        return buffer.toString();
    }
}
