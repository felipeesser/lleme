package patterns.interpreter;

import java.util.Stack;

public abstract class Expressao {

    public static Stack<Expressao> pilha = new Stack<Expressao>();

    public abstract double calcular();
}
