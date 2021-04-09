// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class FormalPar extends FormalParam {

    private Type Type;
    private String formalParamName;
    private OptionalArray OptionalArray;

    public FormalPar (Type Type, String formalParamName, OptionalArray OptionalArray) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.formalParamName=formalParamName;
        this.OptionalArray=OptionalArray;
        if(OptionalArray!=null) OptionalArray.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getFormalParamName() {
        return formalParamName;
    }

    public void setFormalParamName(String formalParamName) {
        this.formalParamName=formalParamName;
    }

    public OptionalArray getOptionalArray() {
        return OptionalArray;
    }

    public void setOptionalArray(OptionalArray OptionalArray) {
        this.OptionalArray=OptionalArray;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(OptionalArray!=null) OptionalArray.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(OptionalArray!=null) OptionalArray.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(OptionalArray!=null) OptionalArray.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalPar(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+formalParamName);
        buffer.append("\n");

        if(OptionalArray!=null)
            buffer.append(OptionalArray.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalPar]");
        return buffer.toString();
    }
}
