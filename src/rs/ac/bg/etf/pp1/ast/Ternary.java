// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public class Ternary implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private Condition Condition;
    private Question Question;
    private Expr Expr;
    private Doubledot Doubledot;
    private Expr Expr1;

    public Ternary (Condition Condition, Question Question, Expr Expr, Doubledot Doubledot, Expr Expr1) {
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.Question=Question;
        if(Question!=null) Question.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.Doubledot=Doubledot;
        if(Doubledot!=null) Doubledot.setParent(this);
        this.Expr1=Expr1;
        if(Expr1!=null) Expr1.setParent(this);
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public Question getQuestion() {
        return Question;
    }

    public void setQuestion(Question Question) {
        this.Question=Question;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public Doubledot getDoubledot() {
        return Doubledot;
    }

    public void setDoubledot(Doubledot Doubledot) {
        this.Doubledot=Doubledot;
    }

    public Expr getExpr1() {
        return Expr1;
    }

    public void setExpr1(Expr Expr1) {
        this.Expr1=Expr1;
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
        if(Condition!=null) Condition.accept(visitor);
        if(Question!=null) Question.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(Doubledot!=null) Doubledot.accept(visitor);
        if(Expr1!=null) Expr1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(Question!=null) Question.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(Doubledot!=null) Doubledot.traverseTopDown(visitor);
        if(Expr1!=null) Expr1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(Question!=null) Question.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(Doubledot!=null) Doubledot.traverseBottomUp(visitor);
        if(Expr1!=null) Expr1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Ternary(\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Question!=null)
            buffer.append(Question.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Doubledot!=null)
            buffer.append(Doubledot.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr1!=null)
            buffer.append(Expr1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Ternary]");
        return buffer.toString();
    }
}
