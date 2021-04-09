// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class ClassDecls extends StaticDecl {

    private ClassName ClassName;
    private OptionalExtends OptionalExtends;
    private FieldList FieldList;
    private Methods Methods;

    public ClassDecls (ClassName ClassName, OptionalExtends OptionalExtends, FieldList FieldList, Methods Methods) {
        this.ClassName=ClassName;
        if(ClassName!=null) ClassName.setParent(this);
        this.OptionalExtends=OptionalExtends;
        if(OptionalExtends!=null) OptionalExtends.setParent(this);
        this.FieldList=FieldList;
        if(FieldList!=null) FieldList.setParent(this);
        this.Methods=Methods;
        if(Methods!=null) Methods.setParent(this);
    }

    public ClassName getClassName() {
        return ClassName;
    }

    public void setClassName(ClassName ClassName) {
        this.ClassName=ClassName;
    }

    public OptionalExtends getOptionalExtends() {
        return OptionalExtends;
    }

    public void setOptionalExtends(OptionalExtends OptionalExtends) {
        this.OptionalExtends=OptionalExtends;
    }

    public FieldList getFieldList() {
        return FieldList;
    }

    public void setFieldList(FieldList FieldList) {
        this.FieldList=FieldList;
    }

    public Methods getMethods() {
        return Methods;
    }

    public void setMethods(Methods Methods) {
        this.Methods=Methods;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassName!=null) ClassName.accept(visitor);
        if(OptionalExtends!=null) OptionalExtends.accept(visitor);
        if(FieldList!=null) FieldList.accept(visitor);
        if(Methods!=null) Methods.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassName!=null) ClassName.traverseTopDown(visitor);
        if(OptionalExtends!=null) OptionalExtends.traverseTopDown(visitor);
        if(FieldList!=null) FieldList.traverseTopDown(visitor);
        if(Methods!=null) Methods.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassName!=null) ClassName.traverseBottomUp(visitor);
        if(OptionalExtends!=null) OptionalExtends.traverseBottomUp(visitor);
        if(FieldList!=null) FieldList.traverseBottomUp(visitor);
        if(Methods!=null) Methods.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecls(\n");

        if(ClassName!=null)
            buffer.append(ClassName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalExtends!=null)
            buffer.append(OptionalExtends.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FieldList!=null)
            buffer.append(FieldList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Methods!=null)
            buffer.append(Methods.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecls]");
        return buffer.toString();
    }
}
