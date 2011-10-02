package patterns.interpreter;

import java.util.Scanner;
import org.omg.CORBA.UserException;

public class Literal extends Expressao {

    public float numero;

    public Literal(float numero) {
        this.numero = numero;
    }

    @Override
    public float interpretar() {
        return numero;
    }

    public static String fragmentarExpressao(String expressaoStr) throws UserException {
        Scanner in = new Scanner(expressaoStr.trim());
        if (in.hasNextFloat()) {
            pilha.add(new Literal(in.nextFloat()));
            if (in.hasNext()) {
                String resto = in.nextLine().trim();
                if (resto.equals(""))
                    return null;
                else
                    return resto;
            } else
                return null;
        } else
            return Soma.fragmentarExpressao(expressaoStr);
    }
}
