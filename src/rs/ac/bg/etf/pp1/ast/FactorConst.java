// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class FactorConst extends Factor {

    private ConstVal ConstVal;

    public FactorConst (ConstVal ConstVal) {
        this.ConstVal=ConstVal;
        if(ConstVal!=null) ConstVal.setParent(this);
    }

    public ConstVal getConstVal() {
        return ConstVal;
    }

    public void setConstVal(ConstVal ConstVal) {
        this.ConstVal=ConstVal;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstVal!=null) ConstVal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstVal!=null) ConstVal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstVal!=null) ConstVal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorConst(\n");

        if(ConstVal!=null)
            buffer.append(ConstVal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorConst]");
        return buffer.toString();
    }
}
