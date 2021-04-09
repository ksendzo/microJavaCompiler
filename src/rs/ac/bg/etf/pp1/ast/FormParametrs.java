// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class FormParametrs extends FormParams {

    private FormParamsComma FormParamsComma;
    private FormalParam FormalParam;

    public FormParametrs (FormParamsComma FormParamsComma, FormalParam FormalParam) {
        this.FormParamsComma=FormParamsComma;
        if(FormParamsComma!=null) FormParamsComma.setParent(this);
        this.FormalParam=FormalParam;
        if(FormalParam!=null) FormalParam.setParent(this);
    }

    public FormParamsComma getFormParamsComma() {
        return FormParamsComma;
    }

    public void setFormParamsComma(FormParamsComma FormParamsComma) {
        this.FormParamsComma=FormParamsComma;
    }

    public FormalParam getFormalParam() {
        return FormalParam;
    }

    public void setFormalParam(FormalParam FormalParam) {
        this.FormalParam=FormalParam;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParamsComma!=null) FormParamsComma.accept(visitor);
        if(FormalParam!=null) FormalParam.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParamsComma!=null) FormParamsComma.traverseTopDown(visitor);
        if(FormalParam!=null) FormalParam.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParamsComma!=null) FormParamsComma.traverseBottomUp(visitor);
        if(FormalParam!=null) FormalParam.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParametrs(\n");

        if(FormParamsComma!=null)
            buffer.append(FormParamsComma.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormalParam!=null)
            buffer.append(FormalParam.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParametrs]");
        return buffer.toString();
    }
}
