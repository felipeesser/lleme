package patterns.decorator;

import org.omg.CORBA.UserException;
import patterns.chainOfResponsabilities.FragmentadorDivisao;
import patterns.chainOfResponsabilities.FragmentadorExpressao;
import patterns.chainOfResponsabilities.FragmentadorLiteral;
import patterns.chainOfResponsabilities.FragmentadorMultiplicacao;
import patterns.chainOfResponsabilities.FragmentadorSoma;
import patterns.chainOfResponsabilities.FragmentadorSubtracao;

public class InterpretadorBasico extends InterpretadorDeExpressao {


    public InterpretadorBasico() {
        FragmentadorExpressao f1;
        FragmentadorExpressao f2;
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
    }


}
