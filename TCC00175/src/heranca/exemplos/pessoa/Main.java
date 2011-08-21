package heranca.exemplos.pessoa;

import heranca.exemplos.pessoa.Aluno;
import heranca.exemplos.pessoa.Pessoa;
import heranca.exemplos.pessoa.Professor;
import heranca.exemplos.pessoa.Pesquisador;

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
