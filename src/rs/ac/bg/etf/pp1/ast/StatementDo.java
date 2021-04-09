// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class StatementDo extends Matched {

    private DoWhile DoWhile;
    private Statement Statement;
    private While While;
    private CondTernary CondTernary;

    public StatementDo (DoWhile DoWhile, Statement Statement, While While, CondTernary CondTernary) {
        this.DoWhile=DoWhile;
        if(DoWhile!=null) DoWhile.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.While=While;
        if(While!=null) While.setParent(this);
        this.CondTernary=CondTernary;
        if(CondTernary!=null) CondTernary.setParent(this);
    }

    public DoWhile getDoWhile() {
        return DoWhile;
    }

    public void setDoWhile(DoWhile DoWhile) {
        this.DoWhile=DoWhile;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public While getWhile() {
        return While;
    }

    public void setWhile(While While) {
        this.While=While;
    }

    public CondTernary getCondTernary() {
        return CondTernary;
    }

    public void setCondTernary(CondTernary CondTernary) {
        this.CondTernary=CondTernary;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DoWhile!=null) DoWhile.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(While!=null) While.accept(visitor);
        if(CondTernary!=null) CondTernary.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DoWhile!=null) DoWhile.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(While!=null) While.traverseTopDown(visitor);
        if(CondTernary!=null) CondTernary.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DoWhile!=null) DoWhile.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(While!=null) While.traverseBottomUp(visitor);
        if(CondTernary!=null) CondTernary.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDo(\n");

        if(DoWhile!=null)
            buffer.append(DoWhile.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(While!=null)
            buffer.append(While.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTernary!=null)
            buffer.append(CondTernary.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDo]");
        return buffer.toString();
    }
}
