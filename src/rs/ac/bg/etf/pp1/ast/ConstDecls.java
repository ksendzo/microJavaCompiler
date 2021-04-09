// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class ConstDecls extends StaticDecl {

    private ConstType ConstType;
    private ConstList ConstList;

    public ConstDecls (ConstType ConstType, ConstList ConstList) {
        this.ConstType=ConstType;
        if(ConstType!=null) ConstType.setParent(this);
        this.ConstList=ConstList;
        if(ConstList!=null) ConstList.setParent(this);
    }

    public ConstType getConstType() {
        return ConstType;
    }

    public void setConstType(ConstType ConstType) {
        this.ConstType=ConstType;
    }

    public ConstList getConstList() {
        return ConstList;
    }

    public void setConstList(ConstList ConstList) {
        this.ConstList=ConstList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstType!=null) ConstType.accept(visitor);
        if(ConstList!=null) ConstList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstType!=null) ConstType.traverseTopDown(visitor);
        if(ConstList!=null) ConstList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstType!=null) ConstType.traverseBottomUp(visitor);
        if(ConstList!=null) ConstList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecls(\n");

        if(ConstType!=null)
            buffer.append(ConstType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstList!=null)
            buffer.append(ConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecls]");
        return buffer.toString();
    }
}
