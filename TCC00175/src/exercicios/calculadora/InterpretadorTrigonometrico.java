package exercicios.calculadora;

import exercicios.calculadora.FragmentadorTangente;
import exercicios.calculadora.FragmentadorCoseno;
import exercicios.calculadora.FragmentadorDeExpressao;
import exercicios.calculadora.FragmentadorSeno;

public class InterpretadorTrigonometrico extends Decorador {

  public InterpretadorTrigonometrico(InterpretadorDeExpressao componente) {
    super(componente);
    FragmentadorDeExpressao f1;
    FragmentadorDeExpressao f2;
    f1 = new FragmentadorSeno();
    cadeiaDeFragmentadores = f1;
    f2 = new FragmentadorCoseno();
    f1.proximo = f2;
    f1 = f2;
    f2 = new FragmentadorTangente();
    f1.proximo = f2;
  }
}
