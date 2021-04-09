// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class CondFactE extends CondFact {

    private ExprNonTer ExprNonTer;

    public CondFactE (ExprNonTer ExprNonTer) {
        this.ExprNonTer=ExprNonTer;
        if(ExprNonTer!=null) ExprNonTer.setParent(this);
    }

    public ExprNonTer getExprNonTer() {
        return ExprNonTer;
    }

    public void setExprNonTer(ExprNonTer ExprNonTer) {
        this.ExprNonTer=ExprNonTer;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprNonTer!=null) ExprNonTer.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprNonTer!=null) ExprNonTer.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprNonTer!=null) ExprNonTer.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFactE(\n");

        if(ExprNonTer!=null)
            buffer.append(ExprNonTer.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFactE]");
        return buffer.toString();
    }
}
