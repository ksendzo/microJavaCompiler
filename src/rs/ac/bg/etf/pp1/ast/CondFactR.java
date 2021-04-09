// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class CondFactR extends CondFact {

    private ExprNonTer ExprNonTer;
    private RelOp RelOp;
    private ExprNonTer ExprNonTer1;

    public CondFactR (ExprNonTer ExprNonTer, RelOp RelOp, ExprNonTer ExprNonTer1) {
        this.ExprNonTer=ExprNonTer;
        if(ExprNonTer!=null) ExprNonTer.setParent(this);
        this.RelOp=RelOp;
        if(RelOp!=null) RelOp.setParent(this);
        this.ExprNonTer1=ExprNonTer1;
        if(ExprNonTer1!=null) ExprNonTer1.setParent(this);
    }

    public ExprNonTer getExprNonTer() {
        return ExprNonTer;
    }

    public void setExprNonTer(ExprNonTer ExprNonTer) {
        this.ExprNonTer=ExprNonTer;
    }

    public RelOp getRelOp() {
        return RelOp;
    }

    public void setRelOp(RelOp RelOp) {
        this.RelOp=RelOp;
    }

    public ExprNonTer getExprNonTer1() {
        return ExprNonTer1;
    }

    public void setExprNonTer1(ExprNonTer ExprNonTer1) {
        this.ExprNonTer1=ExprNonTer1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprNonTer!=null) ExprNonTer.accept(visitor);
        if(RelOp!=null) RelOp.accept(visitor);
        if(ExprNonTer1!=null) ExprNonTer1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprNonTer!=null) ExprNonTer.traverseTopDown(visitor);
        if(RelOp!=null) RelOp.traverseTopDown(visitor);
        if(ExprNonTer1!=null) ExprNonTer1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprNonTer!=null) ExprNonTer.traverseBottomUp(visitor);
        if(RelOp!=null) RelOp.traverseBottomUp(visitor);
        if(ExprNonTer1!=null) ExprNonTer1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFactR(\n");

        if(ExprNonTer!=null)
            buffer.append(ExprNonTer.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RelOp!=null)
            buffer.append(RelOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprNonTer1!=null)
            buffer.append(ExprNonTer1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFactR]");
        return buffer.toString();
    }
}
