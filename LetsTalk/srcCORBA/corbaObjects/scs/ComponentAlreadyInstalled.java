package corbaObjects.scs;

/**
 * corbaObjects/scs/ComponentAlreadyInstalled.java . Generated by the
 * IDL-to-Java compiler (portable), version "3.2" from deployment.idl
 * Sexta-feira, 9 de Dezembro de 2005 18h26min28s BRST
 */

@SuppressWarnings("serial")
public final class ComponentAlreadyInstalled extends
		org.omg.CORBA.UserException {

	public ComponentAlreadyInstalled() {
		super(ComponentAlreadyInstalledHelper.id());
	} // ctor

	public ComponentAlreadyInstalled(String $reason) {
		super(ComponentAlreadyInstalledHelper.id() + "  " + $reason);
	} // ctor

} // class ComponentAlreadyInstalled
