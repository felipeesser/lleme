package patterns.command.app1.control;

import patterns.command.app1.model.Paciente;
import patterns.command.framework.Command;

public class Emagrecer1Kg extends Command {

    Paciente paciente;

    public Emagrecer1Kg(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public void execute() {
        paciente.peso--;
    }

    @Override
    public void desfazer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
