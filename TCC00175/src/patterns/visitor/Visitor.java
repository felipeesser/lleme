package patterns.visitor;

import patterns.interpreter.ExpressaoGenerica;

public abstract class Visitor {

    public abstract void visitExpressao(ExpressaoGenerica expr);
}
