package aula3.exemplos;

public class Retangulo extends Figura {
    public float a;
    public float b;

    public Retangulo(float a, float b) {
        this.a=a;
        this.b=b;
    }

    public float area() {
        return a*b;
    }
}
