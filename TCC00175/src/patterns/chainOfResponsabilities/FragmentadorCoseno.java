package patterns.chainOfResponsabilities;

import java.util.Scanner;
import org.omg.CORBA.UserException;
import patterns.interpreter.Coseno;
import patterns.interpreter.Expressao;

public class FragmentadorCoseno extends FragmentadorExpressao {

    @Override
    public String fragmentarExpressao(String expressaoStr) throws UserException {
        Scanner in = new Scanner(expressaoStr.trim());
        Expressao op1;
        if (in.hasNext("\\cos")) {
            in.next("\\cos");
            if (pilha.size() >= 2) {
                op1 = pilha.pop();
                pilha.add(new Coseno(op1));
                if (in.hasNextLine()) {
                    String resto = in.nextLine().trim();
                    if (resto.equals(""))
                        return null;
                    else
                        return resto;
                } else
                    return null;
            } else
                throw new UserException("Número inválido de operandos para a operação coseno") {
                };
        } else if (proximo != null)
            return proximo.fragmentarExpressao(expressaoStr);
        else
            return expressaoStr;
    }
}
