package exemploAula.corbaClasses;

/**
 * Generated from IDL definition of exception "PropertyAlreadyExists"
 * 
 * @author JacORB IDL compiler
 */

public final class PropertyAlreadyExists extends org.omg.CORBA.UserException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7684047541582096573L;

	public PropertyAlreadyExists() {
		super(exemploAula.corbaClasses.PropertyAlreadyExistsHelper.id());
	}

	public exemploAula.corbaClasses.Property prop;

	public PropertyAlreadyExists(java.lang.String _reason,
			exemploAula.corbaClasses.Property prop) {
		super(exemploAula.corbaClasses.PropertyAlreadyExistsHelper.id() + " "
				+ _reason);
		this.prop = prop;
	}

	public PropertyAlreadyExists(exemploAula.corbaClasses.Property prop) {
		super(exemploAula.corbaClasses.PropertyAlreadyExistsHelper.id());
		this.prop = prop;
	}
}
