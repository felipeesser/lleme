package exemploAula.corbaClasses;

/**
 * Generated from IDL definition of exception "UnknownProperty"
 * 
 * @author JacORB IDL compiler
 */

public final class UnknownPropertyHolder implements
		org.omg.CORBA.portable.Streamable {
	public exemploAula.corbaClasses.UnknownProperty value;

	public UnknownPropertyHolder() {
	}

	public UnknownPropertyHolder(
			final exemploAula.corbaClasses.UnknownProperty initial) {
		value = initial;
	}

	public org.omg.CORBA.TypeCode _type() {
		return exemploAula.corbaClasses.UnknownPropertyHelper.type();
	}

	public void _read(final org.omg.CORBA.portable.InputStream _in) {
		value = exemploAula.corbaClasses.UnknownPropertyHelper.read(_in);
	}

	public void _write(final org.omg.CORBA.portable.OutputStream _out) {
		exemploAula.corbaClasses.UnknownPropertyHelper.write(_out, value);
	}
}
