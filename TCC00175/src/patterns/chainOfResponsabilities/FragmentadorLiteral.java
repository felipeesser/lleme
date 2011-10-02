package patterns.chainOfResponsabilities;

import java.util.Scanner;
import org.omg.CORBA.UserException;
import patterns.interpreter.Literal;

public class FragmentadorLiteral extends FragmentadorDeExpressao {

    public String extrairSimbolo(String expressaoStr) throws UserException {
        Scanner in = new Scanner(expressaoStr.trim());
        if (in.hasNextFloat()) {
            pilha.add(new Literal(in.nextFloat()));
            if (in.hasNextLine()) {
                String resto = in.nextLine().trim();
                if (resto.equals(""))
                    return null;
                else
                    return resto;
            } else
                return null;
        } else if (proximo != null)
            return proximo.extrairSimbolo(expressaoStr);
        else
            return expressaoStr;
    }
}
