package exercicios.calculadora;

import java.util.Scanner;
import exercicios.calculadora.RepresentacaoExpressao;
import exercicios.calculadora.Seno;

public class FragmentadorSeno extends FragmentadorDeExpressao {

  @Override
  public String extrairSimbolo(String expressaoStr) throws Exception {
    if (expressaoStr == null)
      return null;
    Scanner in = new Scanner(expressaoStr.trim());
    RepresentacaoExpressao op1;
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
        throw new Exception("N�mero inv�lido de operandos para a opera��o seno") {
        };
    } else if (proximo != null)
      return proximo.extrairSimbolo(expressaoStr);
    else
      return expressaoStr;
  }
}
