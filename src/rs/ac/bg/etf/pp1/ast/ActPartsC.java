// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class ActPartsC extends ActParts {

    private ActParts ActParts;
    private Expr Expr;

    public ActPartsC (ActParts ActParts, Expr Expr) {
        this.ActParts=ActParts;
        if(ActParts!=null) ActParts.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ActParts getActParts() {
        return ActParts;
    }

    public void setActParts(ActParts ActParts) {
        this.ActParts=ActParts;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParts!=null) ActParts.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParts!=null) ActParts.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParts!=null) ActParts.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActPartsC(\n");

        if(ActParts!=null)
            buffer.append(ActParts.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActPartsC]");
        return buffer.toString();
    }
}
