// generated with ast extension for cup
// version 0.8
// 19/0/2021 13:30:37


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(FormPars FormPars);
    public void visit(DesignatorNonTer DesignatorNonTer);
    public void visit(Factor Factor);
    public void visit(FormParamsComma FormParamsComma);
    public void visit(VarListComma VarListComma);
    public void visit(Statement Statement);
    public void visit(ActPartsOpt ActPartsOpt);
    public void visit(TermNonTer TermNonTer);
    public void visit(AddTerm AddTerm);
    public void visit(MethodDecl MethodDecl);
    public void visit(ConstList ConstList);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(OptActPartsOpt OptActPartsOpt);
    public void visit(Method Method);
    public void visit(ActParts ActParts);
    public void visit(DesigAdditionalNonTer DesigAdditionalNonTer);
    public void visit(FormalParamList FormalParamList);
    public void visit(ExprNonTer ExprNonTer);
    public void visit(FieldList FieldList);
    public void visit(OptMinus OptMinus);
    public void visit(Expr Expr);
    public void visit(AddTermNonTer AddTermNonTer);
    public void visit(IfElseStm IfElseStm);
    public void visit(Cases Cases);
    public void visit(CondFactNonTer CondFactNonTer);
    public void visit(VarDecl VarDecl);
    public void visit(Field Field);
    public void visit(CondTernary CondTernary);
    public void visit(AdditionalConstDecl AdditionalConstDecl);
    public void visit(Unmatched Unmatched);
    public void visit(RelOp RelOp);
    public void visit(OptionalExtends OptionalExtends);
    public void visit(DesigPartsNonTer DesigPartsNonTer);
    public void visit(OptNumPrint OptNumPrint);
    public void visit(ActualParamList ActualParamList);
    public void visit(StaticDeclList StaticDeclList);
    public void visit(OptionalArray OptionalArray);
    public void visit(Methods Methods);
    public void visit(Condition Condition);
    public void visit(ActPartsOptNonTer ActPartsOptNonTer);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(StaticDecl StaticDecl);
    public void visit(ActPartsNonTer ActPartsNonTer);
    public void visit(FormParamList FormParamList);
    public void visit(OptActPartsOptNonTer OptActPartsOptNonTer);
    public void visit(StatementList StatementList);
    public void visit(ConstDecl ConstDecl);
    public void visit(FormParams FormParams);
    public void visit(ConditionNonTer ConditionNonTer);
    public void visit(FormalParam FormalParam);
    public void visit(OptExpr OptExpr);
    public void visit(ClassDeclList ClassDeclList);
    public void visit(FactorNonTer FactorNonTer);
    public void visit(MulOp MulOp);
    public void visit(CondTerm CondTerm);
    public void visit(FormalParamDecl FormalParamDecl);
    public void visit(ActualPars ActualPars);
    public void visit(VarList VarList);
    public void visit(ClassDecl ClassDecl);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(DesigAdditional DesigAdditional);
    public void visit(DesigParts DesigParts);
    public void visit(MethodType MethodType);
    public void visit(AddOp AddOp);
    public void visit(AssignOp AssignOp);
    public void visit(Statements Statements);
    public void visit(DesignatorStatementNonTer DesignatorStatementNonTer);
    public void visit(FormParam FormParam);
    public void visit(AdditionalVarDecl AdditionalVarDecl);
    public void visit(MethodName MethodName);
    public void visit(Matched Matched);
    public void visit(VarDeclList VarDeclList);
    public void visit(CondFact CondFact);
    public void visit(CondTermNonTer CondTermNonTer);
    public void visit(Term Term);
    public void visit(ConstVal ConstVal);
    public void visit(MulOpMod MulOpMod);
    public void visit(MulOpD MulOpD);
    public void visit(MulOpM MulOpM);
    public void visit(AddOpM AddOpM);
    public void visit(AddOpP AddOpP);
    public void visit(RelOpEG RelOpEG);
    public void visit(RelOpG RelOpG);
    public void visit(RelOpEL RelOpEL);
    public void visit(RelOpL RelOpL);
    public void visit(RelOpD RelOpD);
    public void visit(RelOpE RelOpE);
    public void visit(AssignOpE AssignOpE);
    public void visit(NoMinus NoMinus);
    public void visit(OptMin OptMin);
    public void visit(NoNumPrint NoNumPrint);
    public void visit(NumberPrint NumberPrint);
    public void visit(Doubledot Doubledot);
    public void visit(Question Question);
    public void visit(Ternary Ternary);
    public void visit(ExprNonT ExprNonT);
    public void visit(ExprCond ExprCond);
    public void visit(ExprT ExprT);
    public void visit(CondFactR CondFactR);
    public void visit(CondFactE CondFactE);
    public void visit(CondTermT CondTermT);
    public void visit(CondTermC CondTermC);
    public void visit(ConditionT ConditionT);
    public void visit(ConditionC ConditionC);
    public void visit(CondTernaryDerived1 CondTernaryDerived1);
    public void visit(CondTer CondTer);
    public void visit(CondCond CondCond);
    public void visit(TermF TermF);
    public void visit(TermM TermM);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorNewArray FactorNewArray);
    public void visit(FactorNewClass FactorNewClass);
    public void visit(FactorConst FactorConst);
    public void visit(FactorDes FactorDes);
    public void visit(NoAddTerm NoAddTerm);
    public void visit(AddTermA AddTermA);
    public void visit(NoExpr NoExpr);
    public void visit(ExprO ExprO);
    public void visit(ActPartsE ActPartsE);
    public void visit(ActPartsC ActPartsC);
    public void visit(NoActParts NoActParts);
    public void visit(ActPartsO ActPartsO);
    public void visit(NoOptActParts NoOptActParts);
    public void visit(OActPO OActPO);
    public void visit(DesigArr DesigArr);
    public void visit(DesigId DesigId);
    public void visit(NoDesigAddit NoDesigAddit);
    public void visit(DesigAddit DesigAddit);
    public void visit(DesigName DesigName);
    public void visit(Designator Designator);
    public void visit(DesigMinusMinus DesigMinusMinus);
    public void visit(DesigPlusPlus DesigPlusPlus);
    public void visit(DesigMethod DesigMethod);
    public void visit(DesigAssign DesigAssign);
    public void visit(NoStatements NoStatements);
    public void visit(StatementsNew StatementsNew);
    public void visit(Case Case);
    public void visit(NoCases NoCases);
    public void visit(CaseC CaseC);
    public void visit(While While);
    public void visit(DoWhile DoWhile);
    public void visit(Switch Switch);
    public void visit(SwitchStart SwitchStart);
    public void visit(StatementStatement StatementStatement);
    public void visit(StatementPrint StatementPrint);
    public void visit(StatementRead StatementRead);
    public void visit(StatementReturn StatementReturn);
    public void visit(StatementContinue StatementContinue);
    public void visit(StatementBreak StatementBreak);
    public void visit(StatementSwitch StatementSwitch);
    public void visit(StatementDo StatementDo);
    public void visit(StatementIf StatementIf);
    public void visit(MatchedDerived1 MatchedDerived1);
    public void visit(StatementD StatementD);
    public void visit(Else Else);
    public void visit(If If);
    public void visit(UnmatchedElse UnmatchedElse);
    public void visit(UnmatchedIf UnmatchedIf);
    public void visit(UnmatchedStm UnmatchedStm);
    public void visit(MatchedStm MatchedStm);
    public void visit(BoolConst BoolConst);
    public void visit(CharConst CharConst);
    public void visit(NumConst NumConst);
    public void visit(Type Type);
    public void visit(MType MType);
    public void visit(TVoid TVoid);
    public void visit(FormalPar FormalPar);
    public void visit(FormParamsCommaDerived1 FormParamsCommaDerived1);
    public void visit(FormParamsCom FormParamsCom);
    public void visit(FormPar FormPar);
    public void visit(FormParametrs FormParametrs);
    public void visit(FormParamListDerived1 FormParamListDerived1);
    public void visit(NoFromParam NoFromParam);
    public void visit(FormParamL FormParamL);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(MethodDec MethodDec);
    public void visit(NoMethodDecar NoMethodDecar);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(NoMethods NoMethods);
    public void visit(MethodsClass MethodsClass);
    public void visit(FieldDerived1 FieldDerived1);
    public void visit(Fld Fld);
    public void visit(NoFieldDecl NoFieldDecl);
    public void visit(FieldDecls FieldDecls);
    public void visit(OptionalExtendsDerived1 OptionalExtendsDerived1);
    public void visit(NoExtends NoExtends);
    public void visit(Extends Extends);
    public void visit(NoArray NoArray);
    public void visit(Array Array);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(VarType VarType);
    public void visit(VarListCommaDerived1 VarListCommaDerived1);
    public void visit(VarListCom VarListCom);
    public void visit(VarD VarD);
    public void visit(VarListDecl VarListDecl);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(ConstD ConstD);
    public void visit(ConstListDecl ConstListDecl);
    public void visit(ClassName ClassName);
    public void visit(ConstType ConstType);
    public void visit(ClassDecls ClassDecls);
    public void visit(StaticDeclDerived1 StaticDeclDerived1);
    public void visit(VarDecls VarDecls);
    public void visit(ConstDecls ConstDecls);
    public void visit(NoStaticDecl NoStaticDecl);
    public void visit(StatictDeclList StatictDeclList);
    public void visit(ProgName ProgName);
    public void visit(GlobalStart GlobalStart);
    public void visit(Program Program);

}
