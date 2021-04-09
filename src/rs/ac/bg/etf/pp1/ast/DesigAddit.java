// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class DesigAddit extends DesigAdditional {

    private DesigAdditional DesigAdditional;
    private DesigParts DesigParts;

    public DesigAddit (DesigAdditional DesigAdditional, DesigParts DesigParts) {
        this.DesigAdditional=DesigAdditional;
        if(DesigAdditional!=null) DesigAdditional.setParent(this);
        this.DesigParts=DesigParts;
        if(DesigParts!=null) DesigParts.setParent(this);
    }

    public DesigAdditional getDesigAdditional() {
        return DesigAdditional;
    }

    public void setDesigAdditional(DesigAdditional DesigAdditional) {
        this.DesigAdditional=DesigAdditional;
    }

    public DesigParts getDesigParts() {
        return DesigParts;
    }

    public void setDesigParts(DesigParts DesigParts) {
        this.DesigParts=DesigParts;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesigAdditional!=null) DesigAdditional.accept(visitor);
        if(DesigParts!=null) DesigParts.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesigAdditional!=null) DesigAdditional.traverseTopDown(visitor);
        if(DesigParts!=null) DesigParts.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesigAdditional!=null) DesigAdditional.traverseBottomUp(visitor);
        if(DesigParts!=null) DesigParts.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesigAddit(\n");

        if(DesigAdditional!=null)
            buffer.append(DesigAdditional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesigParts!=null)
            buffer.append(DesigParts.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesigAddit]");
        return buffer.toString();
    }
}
