// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class StatictDeclList extends StaticDeclList {

    private StaticDeclList StaticDeclList;
    private StaticDecl StaticDecl;

    public StatictDeclList (StaticDeclList StaticDeclList, StaticDecl StaticDecl) {
        this.StaticDeclList=StaticDeclList;
        if(StaticDeclList!=null) StaticDeclList.setParent(this);
        this.StaticDecl=StaticDecl;
        if(StaticDecl!=null) StaticDecl.setParent(this);
    }

    public StaticDeclList getStaticDeclList() {
        return StaticDeclList;
    }

    public void setStaticDeclList(StaticDeclList StaticDeclList) {
        this.StaticDeclList=StaticDeclList;
    }

    public StaticDecl getStaticDecl() {
        return StaticDecl;
    }

    public void setStaticDecl(StaticDecl StaticDecl) {
        this.StaticDecl=StaticDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StaticDeclList!=null) StaticDeclList.accept(visitor);
        if(StaticDecl!=null) StaticDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StaticDeclList!=null) StaticDeclList.traverseTopDown(visitor);
        if(StaticDecl!=null) StaticDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StaticDeclList!=null) StaticDeclList.traverseBottomUp(visitor);
        if(StaticDecl!=null) StaticDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatictDeclList(\n");

        if(StaticDeclList!=null)
            buffer.append(StaticDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StaticDecl!=null)
            buffer.append(StaticDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatictDeclList]");
        return buffer.toString();
    }
}
