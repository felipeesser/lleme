package provas.s20121.p1.ex1;

import java.util.Date;

public class Vendedor extends Funcionario {

    public Vendedor(String nome, Date admissao, float cargaHoraria) {
        super(nome, admissao, cargaHoraria);
    }

    @Override
    public void accept(Visitante visitante) {
        visitante.visitVendedor(this);
    }
}
