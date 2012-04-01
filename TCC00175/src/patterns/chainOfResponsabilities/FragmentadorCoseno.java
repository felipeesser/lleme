package patterns.chainOfResponsabilities;

import java.util.Scanner;
import patterns.interpreter.Coseno;
import patterns.interpreter.ExpressaoGenerica;

public class FragmentadorCoseno extends FragmentadorDeExpressao {

    @Override
    public String extrairSimbolo(String expressaoStr) throws Exception {
        if (expressaoStr==null)
            return null;
        Scanner in = new Scanner(expressaoStr.trim());
        ExpressaoGenerica op1;
        if (in.hasNext("cos")) {
            in.next("cos");
            if (getPilha().size() >= 1) {
                op1 = getPilha().pop();
                getPilha().add(new Coseno(op1));
                if (in.hasNextLine()) {
                    String resto = in.nextLine().trim();
                    if (resto.equals(""))
                        return null;
                    else
                        return resto;
                } else
                    return null;
            } else
                throw new Exception("N�mero inv�lido de operandos para a opera��o coseno") {
                };
        } else if (proximo != null)
            return proximo.extrairSimbolo(expressaoStr);
        else
            return expressaoStr;
    }
}
