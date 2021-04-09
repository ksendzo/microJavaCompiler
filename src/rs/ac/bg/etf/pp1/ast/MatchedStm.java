// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class MatchedStm extends Statement {

    private Matched Matched;

    public MatchedStm (Matched Matched) {
        this.Matched=Matched;
        if(Matched!=null) Matched.setParent(this);
    }

    public Matched getMatched() {
        return Matched;
    }

    public void setMatched(Matched Matched) {
        this.Matched=Matched;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Matched!=null) Matched.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Matched!=null) Matched.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Matched!=null) Matched.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MatchedStm(\n");

        if(Matched!=null)
            buffer.append(Matched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MatchedStm]");
        return buffer.toString();
    }
}
