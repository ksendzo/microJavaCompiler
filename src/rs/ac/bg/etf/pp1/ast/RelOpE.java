// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class RelOpE extends RelOp {

    public RelOpE () {
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
        buffer.append("RelOpE(\n");

        buffer.append(tab);
        buffer.append(") [RelOpE]");
        return buffer.toString();
    }
}
