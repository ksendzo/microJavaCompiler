// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class StatementReturn extends Matched {

    private OptExpr OptExpr;

    public StatementReturn (OptExpr OptExpr) {
        this.OptExpr=OptExpr;
        if(OptExpr!=null) OptExpr.setParent(this);
    }

    public OptExpr getOptExpr() {
        return OptExpr;
    }

    public void setOptExpr(OptExpr OptExpr) {
        this.OptExpr=OptExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptExpr!=null) OptExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptExpr!=null) OptExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptExpr!=null) OptExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementReturn(\n");

        if(OptExpr!=null)
            buffer.append(OptExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementReturn]");
        return buffer.toString();
    }
}
