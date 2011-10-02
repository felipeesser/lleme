package patterns.interpreter;

public class Literal extends Expressao {

    public float numero;

    public Literal(float numero) {
        this.numero = numero;
    }

    @Override
    public float interpretar() {
        return numero;
    }
}
