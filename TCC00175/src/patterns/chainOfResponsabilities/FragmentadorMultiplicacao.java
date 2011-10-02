package patterns.chainOfResponsabilities;

import java.util.Scanner;
import org.omg.CORBA.UserException;
import patterns.interpreter.Expressao;
import patterns.interpreter.Multiplicacao;

public class FragmentadorMultiplicacao extends FragmentadorExpressao {

    public String fragmentarExpressao(String expressaoStr) throws UserException {
        Scanner in = new Scanner(expressaoStr.trim());
        Expressao op1;
        Expressao op2;
        if (in.hasNext("\\*")) {
            in.next("\\*");
            if (pilha.size() >= 2) {
                op2 = pilha.pop();
                op1 = pilha.pop();
                pilha.add(new Multiplicacao(op1, op2));
                if (in.hasNextLine()) {
                    String resto = in.nextLine().trim();
                    if (resto.equals(""))
                        return null;
                    else
                        return resto;
                } else
                    return null;
            } else
                throw new UserException("N�mero inv�lido de operandos para a opera��o de multiplicacao") {
                };
        } else if (proximo != null)
            return proximo.fragmentarExpressao(expressaoStr);
        else
            return expressaoStr;
    }
}
