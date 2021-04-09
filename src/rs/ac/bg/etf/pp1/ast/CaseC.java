// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class CaseC extends Cases {

    private Cases Cases;
    private Case Case;
    private Integer N3;
    private Statements Statements;

    public CaseC (Cases Cases, Case Case, Integer N3, Statements Statements) {
        this.Cases=Cases;
        if(Cases!=null) Cases.setParent(this);
        this.Case=Case;
        if(Case!=null) Case.setParent(this);
        this.N3=N3;
        this.Statements=Statements;
        if(Statements!=null) Statements.setParent(this);
    }

    public Cases getCases() {
        return Cases;
    }

    public void setCases(Cases Cases) {
        this.Cases=Cases;
    }

    public Case getCase() {
        return Case;
    }

    public void setCase(Case Case) {
        this.Case=Case;
    }

    public Integer getN3() {
        return N3;
    }

    public void setN3(Integer N3) {
        this.N3=N3;
    }

    public Statements getStatements() {
        return Statements;
    }

    public void setStatements(Statements Statements) {
        this.Statements=Statements;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Cases!=null) Cases.accept(visitor);
        if(Case!=null) Case.accept(visitor);
        if(Statements!=null) Statements.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Cases!=null) Cases.traverseTopDown(visitor);
        if(Case!=null) Case.traverseTopDown(visitor);
        if(Statements!=null) Statements.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Cases!=null) Cases.traverseBottomUp(visitor);
        if(Case!=null) Case.traverseBottomUp(visitor);
        if(Statements!=null) Statements.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CaseC(\n");

        if(Cases!=null)
            buffer.append(Cases.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Case!=null)
            buffer.append(Case.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+N3);
        buffer.append("\n");

        if(Statements!=null)
            buffer.append(Statements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CaseC]");
        return buffer.toString();
    }
}
