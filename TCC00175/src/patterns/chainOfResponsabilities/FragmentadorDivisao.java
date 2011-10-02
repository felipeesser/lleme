package patterns.chainOfResponsabilities;

import java.util.Scanner;
import org.omg.CORBA.UserException;
import patterns.interpreter.Divisao;
import patterns.interpreter.Expressao;

public class FragmentadorDivisao extends FragmentadorDeExpressao {

    public String extrairSimbolo(String expressaoStr) throws UserException {
        Scanner in = new Scanner(expressaoStr.trim());
        Expressao op1;
        Expressao op2;
        if (in.hasNext("/")) {
            in.next("/");
            if (getPilha().size() >= 2) {
                op2 = getPilha().pop();
                op1 = getPilha().pop();
                getPilha().add(new Divisao(op1, op2));
                if (in.hasNextLine()) {
                    String resto = in.nextLine().trim();
                    if (resto.equals(""))
                        return null;
                    else
                        return resto;
                } else
                    return null;
            } else
                throw new UserException("Número inválido de operandos para a operação de divisao") {
                };
        } else if (proximo != null)
            return proximo.extrairSimbolo(expressaoStr);
        else
            return expressaoStr;
    }
}
