package patterns.decorator;

import patterns.chainOfResponsabilities.FragmentadorCoseno;
import patterns.chainOfResponsabilities.FragmentadorExpressao;
import patterns.chainOfResponsabilities.FragmentadorSeno;

public class InterpretadorTrigonometrico extends Decorador {

    public InterpretadorTrigonometrico(InterpretadorDeExpressao componente) {
        super(componente);
        FragmentadorExpressao f1;
        FragmentadorExpressao f2;
        f1 = new FragmentadorSeno();
        cadeiaDeFragmentadores = f1;
        f2 = new FragmentadorCoseno();
        f1.proximo = f2;
    }
}
