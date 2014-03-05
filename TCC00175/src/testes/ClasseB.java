package testes;

public class ClasseB {

    public static void main(String[] args) {
        ClasseA ca = new ClasseA();
        ClasseA.MementoClassA mca = ca.createMemento();
        ca.setMemento(mca);
    }

}
