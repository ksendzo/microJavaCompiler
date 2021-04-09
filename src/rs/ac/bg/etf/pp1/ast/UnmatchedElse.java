// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class UnmatchedElse extends Unmatched {

    private If If;
    private CondTernary CondTernary;
    private Matched Matched;
    private Else Else;
    private Unmatched Unmatched;

    public UnmatchedElse (If If, CondTernary CondTernary, Matched Matched, Else Else, Unmatched Unmatched) {
        this.If=If;
        if(If!=null) If.setParent(this);
        this.CondTernary=CondTernary;
        if(CondTernary!=null) CondTernary.setParent(this);
        this.Matched=Matched;
        if(Matched!=null) Matched.setParent(this);
        this.Else=Else;
        if(Else!=null) Else.setParent(this);
        this.Unmatched=Unmatched;
        if(Unmatched!=null) Unmatched.setParent(this);
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

    public Matched getMatched() {
        return Matched;
    }

    public void setMatched(Matched Matched) {
        this.Matched=Matched;
    }

    public Else getElse() {
        return Else;
    }

    public void setElse(Else Else) {
        this.Else=Else;
    }

    public Unmatched getUnmatched() {
        return Unmatched;
    }

    public void setUnmatched(Unmatched Unmatched) {
        this.Unmatched=Unmatched;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(If!=null) If.accept(visitor);
        if(CondTernary!=null) CondTernary.accept(visitor);
        if(Matched!=null) Matched.accept(visitor);
        if(Else!=null) Else.accept(visitor);
        if(Unmatched!=null) Unmatched.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(If!=null) If.traverseTopDown(visitor);
        if(CondTernary!=null) CondTernary.traverseTopDown(visitor);
        if(Matched!=null) Matched.traverseTopDown(visitor);
        if(Else!=null) Else.traverseTopDown(visitor);
        if(Unmatched!=null) Unmatched.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(If!=null) If.traverseBottomUp(visitor);
        if(CondTernary!=null) CondTernary.traverseBottomUp(visitor);
        if(Matched!=null) Matched.traverseBottomUp(visitor);
        if(Else!=null) Else.traverseBottomUp(visitor);
        if(Unmatched!=null) Unmatched.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnmatchedElse(\n");

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

        if(Matched!=null)
            buffer.append(Matched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Else!=null)
            buffer.append(Else.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Unmatched!=null)
            buffer.append(Unmatched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnmatchedElse]");
        return buffer.toString();
    }
}
