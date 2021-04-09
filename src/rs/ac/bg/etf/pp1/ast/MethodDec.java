// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class MethodDec extends Method {

    private MethodTypeName MethodTypeName;
    private FormParamList FormParamList;
    private FieldList FieldList;
    private Statements Statements;

    public MethodDec (MethodTypeName MethodTypeName, FormParamList FormParamList, FieldList FieldList, Statements Statements) {
        this.MethodTypeName=MethodTypeName;
        if(MethodTypeName!=null) MethodTypeName.setParent(this);
        this.FormParamList=FormParamList;
        if(FormParamList!=null) FormParamList.setParent(this);
        this.FieldList=FieldList;
        if(FieldList!=null) FieldList.setParent(this);
        this.Statements=Statements;
        if(Statements!=null) Statements.setParent(this);
    }

    public MethodTypeName getMethodTypeName() {
        return MethodTypeName;
    }

    public void setMethodTypeName(MethodTypeName MethodTypeName) {
        this.MethodTypeName=MethodTypeName;
    }

    public FormParamList getFormParamList() {
        return FormParamList;
    }

    public void setFormParamList(FormParamList FormParamList) {
        this.FormParamList=FormParamList;
    }

    public FieldList getFieldList() {
        return FieldList;
    }

    public void setFieldList(FieldList FieldList) {
        this.FieldList=FieldList;
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
        if(MethodTypeName!=null) MethodTypeName.accept(visitor);
        if(FormParamList!=null) FormParamList.accept(visitor);
        if(FieldList!=null) FieldList.accept(visitor);
        if(Statements!=null) Statements.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodTypeName!=null) MethodTypeName.traverseTopDown(visitor);
        if(FormParamList!=null) FormParamList.traverseTopDown(visitor);
        if(FieldList!=null) FieldList.traverseTopDown(visitor);
        if(Statements!=null) Statements.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodTypeName!=null) MethodTypeName.traverseBottomUp(visitor);
        if(FormParamList!=null) FormParamList.traverseBottomUp(visitor);
        if(FieldList!=null) FieldList.traverseBottomUp(visitor);
        if(Statements!=null) Statements.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDec(\n");

        if(MethodTypeName!=null)
            buffer.append(MethodTypeName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParamList!=null)
            buffer.append(FormParamList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FieldList!=null)
            buffer.append(FieldList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statements!=null)
            buffer.append(Statements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDec]");
        return buffer.toString();
    }
}
