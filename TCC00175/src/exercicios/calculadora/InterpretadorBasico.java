package exercicios.calculadora;

import exercicios.calculadora.FragmentadorVariavel;
import exercicios.calculadora.FragmentadorSoma;
import exercicios.calculadora.FragmentadorLiteral;
import exercicios.calculadora.FragmentadorMultiplicacao;
import exercicios.calculadora.FragmentadorDivisao;
import exercicios.calculadora.FragmentadorDeExpressao;
import exercicios.calculadora.FragmentadorSubtracao;

public class InterpretadorBasico extends InterpretadorDeExpressao {

  public InterpretadorBasico() {
    FragmentadorDeExpressao f1;
    FragmentadorDeExpressao f2;
    f1 = new FragmentadorLiteral();
    cadeiaDeFragmentadores = f1;
    f2 = new FragmentadorVariavel();
    f1.proximo = f2;
    f1 = f2;
    f2 = new FragmentadorSoma();
    f1.proximo = f2;
    f1 = f2;
    f2 = new FragmentadorSubtracao();
    f1.proximo = f2;
    f1 = f2;
    f2 = new FragmentadorMultiplicacao();
    f1.proximo = f2;
    f1 = f2;
    f2 = new FragmentadorDivisao();
    f1.proximo = f2;

  }
}