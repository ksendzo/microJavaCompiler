// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private ProgName ProgName;
    private StaticDeclList StaticDeclList;
    private GlobalStart GlobalStart;
    private MethodDeclList MethodDeclList;

    public Program (ProgName ProgName, StaticDeclList StaticDeclList, GlobalStart GlobalStart, MethodDeclList MethodDeclList) {
        this.ProgName=ProgName;
        if(ProgName!=null) ProgName.setParent(this);
        this.StaticDeclList=StaticDeclList;
        if(StaticDeclList!=null) StaticDeclList.setParent(this);
        this.GlobalStart=GlobalStart;
        if(GlobalStart!=null) GlobalStart.setParent(this);
        this.MethodDeclList=MethodDeclList;
        if(MethodDeclList!=null) MethodDeclList.setParent(this);
    }

    public ProgName getProgName() {
        return ProgName;
    }

    public void setProgName(ProgName ProgName) {
        this.ProgName=ProgName;
    }

    public StaticDeclList getStaticDeclList() {
        return StaticDeclList;
    }

    public void setStaticDeclList(StaticDeclList StaticDeclList) {
        this.StaticDeclList=StaticDeclList;
    }

    public GlobalStart getGlobalStart() {
        return GlobalStart;
    }

    public void setGlobalStart(GlobalStart GlobalStart) {
        this.GlobalStart=GlobalStart;
    }

    public MethodDeclList getMethodDeclList() {
        return MethodDeclList;
    }

    public void setMethodDeclList(MethodDeclList MethodDeclList) {
        this.MethodDeclList=MethodDeclList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgName!=null) ProgName.accept(visitor);
        if(StaticDeclList!=null) StaticDeclList.accept(visitor);
        if(GlobalStart!=null) GlobalStart.accept(visitor);
        if(MethodDeclList!=null) MethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgName!=null) ProgName.traverseTopDown(visitor);
        if(StaticDeclList!=null) StaticDeclList.traverseTopDown(visitor);
        if(GlobalStart!=null) GlobalStart.traverseTopDown(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgName!=null) ProgName.traverseBottomUp(visitor);
        if(StaticDeclList!=null) StaticDeclList.traverseBottomUp(visitor);
        if(GlobalStart!=null) GlobalStart.traverseBottomUp(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(ProgName!=null)
            buffer.append(ProgName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StaticDeclList!=null)
            buffer.append(StaticDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalStart!=null)
            buffer.append(GlobalStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclList!=null)
            buffer.append(MethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
