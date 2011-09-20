package patterns.command.app1.control;

import patterns.command.app1.model.MementoPaciente;
import patterns.command.app1.model.Paciente;
import patterns.command.framework.Command;

public class Engordar1Kg extends Command{
    
    public Paciente paciente;
    private MementoPaciente m;

    public Engordar1Kg(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public void execute() {
        m=paciente.createMemento();
        paciente.peso++;
    }

    @Override
    public void desfazer() {
        paciente.setMemento(m);
    }
    
}
