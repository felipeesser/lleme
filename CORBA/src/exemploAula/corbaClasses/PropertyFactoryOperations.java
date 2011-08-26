package exemploAula.corbaClasses;

/**
 * Generated from IDL interface "PropertyFactory"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public interface PropertyFactoryOperations {
	/* constants */
	/* operations */
	exemploAula.corbaClasses.Property create(java.lang.String name,
			java.lang.String initial_value)
			throws exemploAula.corbaClasses.PropertyAlreadyExists;

	void destroy(java.lang.String name)
			throws exemploAula.corbaClasses.UnknownProperty;

	exemploAula.corbaClasses.Property get(java.lang.String name);

	exemploAula.corbaClasses.Property[] getAll();
}
