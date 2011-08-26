package lleme.lib.observer;

/**
 * @author Luiz Leme
 */
public class ObserverImpl implements Observer {

	public void update() {
		// TODO Auto-generated method stub

	}

	/**
	 * @return Returns the state.
	 * @uml.property name="state"
	 */
	public Object getState() {
		return state;
	}

	/**
	 * @param state
	 *            The state to set.
	 * @uml.property name="state"
	 */
	public void setState(Object state) {
		this.state = state;
	}

	private SubjectImpl subjectImpl;

	private Object state;
}
