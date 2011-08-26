package lleme.lib.command;

/**
 * @author Luiz Leme
 */
public class ConcreteCommand extends Command {
	public void execute() {
	}

	/**
	 * @return Returns the state.
	 * @uml.property name="state"
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state
	 *            The state to set.
	 * @uml.property name="state"
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * @directed
	 */
	private Receiver lnkReceiver = null;

	private int state;
}
