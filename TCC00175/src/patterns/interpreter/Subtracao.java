package patterns.interpreter;

import java.util.Scanner;
import org.omg.CORBA.UserException;

public class Subtracao extends OperacaoBinaria {

    public Subtracao(Expressao operando1, Expressao operando2) {
        super(operando1, operando2);
    }

    @Override
    public float interpretar() {
        return operando1.interpretar() - operando2.interpretar();
    }

    static String fragmentarExpressao(String expressaoStr) throws UserException {
        Scanner in = new Scanner(expressaoStr.trim());
        Expressao op1;
        Expressao op2;
        if (in.hasNext("\\-")) {
            in.next("\\-");
            if (pilha.size() >= 2) {
                op2 = pilha.pop();
                op1 = pilha.pop();
                pilha.add(new Subtracao(op1, op2));
                if (in.hasNext()) {
                    String resto = in.nextLine().trim();
                    if (resto.equals(""))
                        return null;
                    else
                        return resto;
                } else
                    return null;
            } else
                throw new UserException("N�mero inv�lido de operandos para a opera��o de subtracao") {
                };
        } else
            return Multiplicacao.fragmentarExpressao(in.nextLine());

    }
}