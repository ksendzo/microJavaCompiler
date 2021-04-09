// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class CharConst extends ConstVal {

    private String C1;

    public CharConst (String C1) {
        this.C1=C1;
    }

    public String getC1() {
        return C1;
    }

    public void setC1(String C1) {
        this.C1=C1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CharConst(\n");

        buffer.append(" "+tab+C1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CharConst]");
        return buffer.toString();
    }
}
