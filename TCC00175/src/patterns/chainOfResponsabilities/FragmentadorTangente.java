/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.chainOfResponsabilities;

import java.util.Scanner;
import patterns.interpreter.Expressao;
import patterns.interpreter.Tangente;

/**
 *
 * @author Luiz Leme
 */
public class FragmentadorTangente extends FragmentadorDeExpressao {

    @Override
    public String extrairSimbolo(String expressaoStr) throws Exception {
        Scanner in = new Scanner(expressaoStr.trim());
        Expressao op1;
        if (in.hasNext("tan")) {
            in.next("tan");
            if (getPilha().size() >= 1) {
                op1 = getPilha().pop();
                getPilha().add(new Tangente(op1));
                if (in.hasNextLine()) {
                    String resto = in.nextLine().trim();
                    if (resto.equals(""))
                        return null;
                    else
                        return resto;
                } else
                    return null;
            } else
                throw new Exception("Número inválido de operandos para a operação tangente") {
                };
        } else if (proximo != null)
            return proximo.extrairSimbolo(expressaoStr);
        else
            return expressaoStr;
    }
}
