// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class FieldDecls extends FieldList {

    private Field Field;
    private FieldList FieldList;

    public FieldDecls (Field Field, FieldList FieldList) {
        this.Field=Field;
        if(Field!=null) Field.setParent(this);
        this.FieldList=FieldList;
        if(FieldList!=null) FieldList.setParent(this);
    }

    public Field getField() {
        return Field;
    }

    public void setField(Field Field) {
        this.Field=Field;
    }

    public FieldList getFieldList() {
        return FieldList;
    }

    public void setFieldList(FieldList FieldList) {
        this.FieldList=FieldList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Field!=null) Field.accept(visitor);
        if(FieldList!=null) FieldList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Field!=null) Field.traverseTopDown(visitor);
        if(FieldList!=null) FieldList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Field!=null) Field.traverseBottomUp(visitor);
        if(FieldList!=null) FieldList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FieldDecls(\n");

        if(Field!=null)
            buffer.append(Field.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FieldList!=null)
            buffer.append(FieldList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FieldDecls]");
        return buffer.toString();
    }
}
