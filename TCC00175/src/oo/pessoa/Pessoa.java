package oo.pessoa;

import java.util.Date;

public class Pessoa {

      public Date nascimento;
      public float altura;
      public float peso;
      public static String nacionalidade;
  
    public Pessoa(Date nascimento) throws Exception {
        this.nascimento = nascimento;
    }

    public double imc() {
        if (altura != 0 && peso != 0)
            return peso / (altura * altura);
        else
            return 0;
    }

    public int idade(Date data) {
        if (nascimento != null && data != null) {
            long diff = data.getTime() - nascimento.getTime();
            if (diff > 0)
                return (int)(diff / (365L * 24L * 60L * 60L * 1000L));
            else
                return 0;
        } else
            return 0;
    }

}
