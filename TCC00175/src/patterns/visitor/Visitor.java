package patterns.visitor;

import patterns.interpreter.RepresentacaoExpressao;

public abstract class Visitor {

    public abstract void visitExpressao(RepresentacaoExpressao expr);
}
