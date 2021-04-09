// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class AddTermA extends AddTerm {

    private AddTerm AddTerm;
    private AddOp AddOp;
    private Term Term;

    public AddTermA (AddTerm AddTerm, AddOp AddOp, Term Term) {
        this.AddTerm=AddTerm;
        if(AddTerm!=null) AddTerm.setParent(this);
        this.AddOp=AddOp;
        if(AddOp!=null) AddOp.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public AddTerm getAddTerm() {
        return AddTerm;
    }

    public void setAddTerm(AddTerm AddTerm) {
        this.AddTerm=AddTerm;
    }

    public AddOp getAddOp() {
        return AddOp;
    }

    public void setAddOp(AddOp AddOp) {
        this.AddOp=AddOp;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AddTerm!=null) AddTerm.accept(visitor);
        if(AddOp!=null) AddOp.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddTerm!=null) AddTerm.traverseTopDown(visitor);
        if(AddOp!=null) AddOp.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddTerm!=null) AddTerm.traverseBottomUp(visitor);
        if(AddOp!=null) AddOp.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AddTermA(\n");

        if(AddTerm!=null)
            buffer.append(AddTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddOp!=null)
            buffer.append(AddOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AddTermA]");
        return buffer.toString();
    }
}
