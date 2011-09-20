package patterns.command.framework;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

    private List<Command> commands = new ArrayList<Command>();
    public Command opcao1 = null;
    public Command opcao2 = null;
    public Command opcao3 = null;

    public void acionarOpcao1() {
        opcao1.execute();
    }

    public void acionarOpcao2() {
        opcao2.execute();
    }

    public void acionarOpcao3() {
        opcao3.execute();
    }

    public void desfazer() {
    }
}
