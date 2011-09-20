package patterns.command.framework;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand extends Command {
    
    public List<Command> commands = new ArrayList<Command>();
    
    @Override
    public void execute() {
        for (Command ct : commands)
            ct.execute();
    }

    @Override
    public void desfazer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
