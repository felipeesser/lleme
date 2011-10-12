package patterns.interpreter;

import java.util.Stack;

import patterns.visitor.Visitor;


public abstract class Expressao {

    public static Stack<Expressao> pilha = new Stack<Expressao>();

    public abstract double calcular();

    public abstract void setValor(double valor);

    public abstract String getNome();
    
    public abstract void accept(Visitor visitor);
    
}
