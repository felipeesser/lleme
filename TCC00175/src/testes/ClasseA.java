package testes;

public class ClasseA {

    public class MementoClassA {

        private MementoClassA() {
        }

        private void metodo1() {
        }
    }

    public void metodo1() {
        MementoClassA in = new MementoClassA();
        in.metodo1();

    }

    public MementoClassA createMemento() {
        return new MementoClassA();
    }

    public void setMemento(MementoClassA m) {
        m.metodo1();
    }
}
