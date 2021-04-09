// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class DesigMethod extends DesignatorStatement {

    private Designator Designator;
    private ActPartsOpt ActPartsOpt;

    public DesigMethod (Designator Designator, ActPartsOpt ActPartsOpt) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActPartsOpt=ActPartsOpt;
        if(ActPartsOpt!=null) ActPartsOpt.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
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
        if(Designator!=null) Designator.accept(visitor);
        if(ActPartsOpt!=null) ActPartsOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActPartsOpt!=null) ActPartsOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActPartsOpt!=null) ActPartsOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesigMethod(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActPartsOpt!=null)
            buffer.append(ActPartsOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesigMethod]");
        return buffer.toString();
    }
}
