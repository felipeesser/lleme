package patterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public List<Prototipo> prototipos = new ArrayList<Prototipo>();

    public static void main(String[] args) throws CloneNotSupportedException {

        Prototipo.tipoClonagem = 3;
        Cliente cliente = new Cliente();
        cliente.prototipos.add(new Aluno());


        Prototipo<String> objeto1 = cliente.prototipos.get(0);
        Prototipo<String> objeto2 = (Aluno) objeto1.clone();

        objeto1.setNome("Luiz Andr�");
        objeto1.getColecao().add(objeto1.getNome());

        objeto2.setNome("outro nome");
        objeto2.getColecao().clear();
        objeto2.getColecao().add(objeto2.getNome());
    }
}
