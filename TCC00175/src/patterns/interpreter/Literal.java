package patterns.interpreter;

public class Literal extends Expressao {

    public double numero;

    public Literal(double numero) {
        this.numero = numero;
    }

    @Override
    public double calcular() {
        return numero;
    }
}
