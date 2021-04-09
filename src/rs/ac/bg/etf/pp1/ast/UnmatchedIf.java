// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class UnmatchedIf extends Unmatched {

    private If If;
    private CondTernary CondTernary;
    private Statement Statement;

    public UnmatchedIf (If If, CondTernary CondTernary, Statement Statement) {
        this.If=If;
        if(If!=null) If.setParent(this);
        this.CondTernary=CondTernary;
        if(CondTernary!=null) CondTernary.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public If getIf() {
        return If;
    }

    public void setIf(If If) {
        this.If=If;
    }

    public CondTernary getCondTernary() {
        return CondTernary;
    }

    public void setCondTernary(CondTernary CondTernary) {
        this.CondTernary=CondTernary;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(If!=null) If.accept(visitor);
        if(CondTernary!=null) CondTernary.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(If!=null) If.traverseTopDown(visitor);
        if(CondTernary!=null) CondTernary.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(If!=null) If.traverseBottomUp(visitor);
        if(CondTernary!=null) CondTernary.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnmatchedIf(\n");

        if(If!=null)
            buffer.append(If.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTernary!=null)
            buffer.append(CondTernary.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnmatchedIf]");
        return buffer.toString();
    }
}
