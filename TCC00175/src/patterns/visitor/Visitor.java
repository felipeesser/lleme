package patterns.visitor;

import patterns.interpreter.Expressao;

public abstract class Visitor {

    public abstract void visitExpressao(Expressao expr);
}
