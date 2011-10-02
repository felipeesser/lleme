package patterns.decorator;

import patterns.chainOfResponsabilities.FragmentadorCoseno;
import patterns.chainOfResponsabilities.FragmentadorDeExpressao;
import patterns.chainOfResponsabilities.FragmentadorSeno;

public class InterpretadorTrigonometrico extends Decorador {

    public InterpretadorTrigonometrico(InterpretadorDeExpressao componente) {
        super(componente);
        FragmentadorDeExpressao f1;
        FragmentadorDeExpressao f2;
        f1 = new FragmentadorSeno();
        cadeiaDeFragmentadores = f1;
        f2 = new FragmentadorCoseno();
        f1.proximo = f2;
    }
}
