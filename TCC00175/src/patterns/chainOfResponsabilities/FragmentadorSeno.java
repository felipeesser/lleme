package patterns.chainOfResponsabilities;

import java.util.Scanner;
import patterns.interpreter.Expressao;
import patterns.interpreter.Seno;

public class FragmentadorSeno extends FragmentadorDeExpressao {

    @Override
    public String extrairSimbolo(String expressaoStr) throws Exception {
        Scanner in = new Scanner(expressaoStr.trim());
        Expressao op1;
        if (in.hasNext("sen")) {
            in.next("sen");
            if (getPilha().size() >= 1) {
                op1 = getPilha().pop();
                getPilha().add(new Seno(op1));
                if (in.hasNextLine()) {
                    String resto = in.nextLine().trim();
                    if (resto.equals(""))
                        return null;
                    else
                        return resto;
                } else
                    return null;
            } else
                throw new Exception("Número inválido de operandos para a operação seno") {
                };
        } else if (proximo != null)
            return proximo.extrairSimbolo(expressaoStr);
        else
            return expressaoStr;
    }
}
