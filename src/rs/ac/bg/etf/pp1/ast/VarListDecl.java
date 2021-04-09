// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class VarListDecl extends VarList {

    private VarListComma VarListComma;
    private VarDeclaration VarDeclaration;

    public VarListDecl (VarListComma VarListComma, VarDeclaration VarDeclaration) {
        this.VarListComma=VarListComma;
        if(VarListComma!=null) VarListComma.setParent(this);
        this.VarDeclaration=VarDeclaration;
        if(VarDeclaration!=null) VarDeclaration.setParent(this);
    }

    public VarListComma getVarListComma() {
        return VarListComma;
    }

    public void setVarListComma(VarListComma VarListComma) {
        this.VarListComma=VarListComma;
    }

    public VarDeclaration getVarDeclaration() {
        return VarDeclaration;
    }

    public void setVarDeclaration(VarDeclaration VarDeclaration) {
        this.VarDeclaration=VarDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarListComma!=null) VarListComma.accept(visitor);
        if(VarDeclaration!=null) VarDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarListComma!=null) VarListComma.traverseTopDown(visitor);
        if(VarDeclaration!=null) VarDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarListComma!=null) VarListComma.traverseBottomUp(visitor);
        if(VarDeclaration!=null) VarDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarListDecl(\n");

        if(VarListComma!=null)
            buffer.append(VarListComma.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclaration!=null)
            buffer.append(VarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarListDecl]");
        return buffer.toString();
    }
}
