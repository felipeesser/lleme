package patterns.decorator;

import patterns.chainOfResponsabilities.FragmentadorDivisao;
import patterns.chainOfResponsabilities.FragmentadorDeExpressao;
import patterns.chainOfResponsabilities.FragmentadorLiteral;
import patterns.chainOfResponsabilities.FragmentadorMultiplicacao;
import patterns.chainOfResponsabilities.FragmentadorSoma;
import patterns.chainOfResponsabilities.FragmentadorSubtracao;
import patterns.chainOfResponsabilities.FragmentadorVariavel;

public class InterpretadorBasico extends InterpretadorDeExpressao {

    public InterpretadorBasico() {
        FragmentadorDeExpressao f1;
        FragmentadorDeExpressao f2;
        f1 = new FragmentadorLiteral();
        cadeiaDeFragmentadores = f1;
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
        f1 = f2;
        f2 = new FragmentadorVariavel();
        f1.proximo = f2;
    }
}
