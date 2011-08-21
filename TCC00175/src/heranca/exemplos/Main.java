package heranca.exemplos;

public class Main {
    public Main() {
        super();
        Professor prof = new Professor();
        Integer inteiro = new Integer(10);
        Pesquisador pesq = prof;
        System.out.println(pesq.metodo());
        Object obj = prof;
        pesq = (Pesquisador)obj;
        Pessoa pess = new Aluno();

    }
}
