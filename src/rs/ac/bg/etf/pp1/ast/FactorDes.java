// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class FactorDes extends Factor {

    private Designator Designator;
    private OptActPartsOpt OptActPartsOpt;

    public FactorDes (Designator Designator, OptActPartsOpt OptActPartsOpt) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.OptActPartsOpt=OptActPartsOpt;
        if(OptActPartsOpt!=null) OptActPartsOpt.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public OptActPartsOpt getOptActPartsOpt() {
        return OptActPartsOpt;
    }

    public void setOptActPartsOpt(OptActPartsOpt OptActPartsOpt) {
        this.OptActPartsOpt=OptActPartsOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(OptActPartsOpt!=null) OptActPartsOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(OptActPartsOpt!=null) OptActPartsOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(OptActPartsOpt!=null) OptActPartsOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDes(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptActPartsOpt!=null)
            buffer.append(OptActPartsOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDes]");
        return buffer.toString();
    }
}
