package exemploAula.corbaClasses;

/**
 * Generated from IDL interface "Property"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public final class PropertyHelper {
	public static void insert(final org.omg.CORBA.Any any,
			final exemploAula.corbaClasses.Property s) {
		any.insert_Object(s);
	}

	public static exemploAula.corbaClasses.Property extract(
			final org.omg.CORBA.Any any) {
		return narrow(any.extract_Object());
	}

	public static org.omg.CORBA.TypeCode type() {
		return org.omg.CORBA.ORB.init().create_interface_tc(
				"IDL:exemploAula/corbaClasses/Property:1.0", "Property");
	}

	public static String id() {
		return "IDL:exemploAula/corbaClasses/Property:1.0";
	}

	public static Property read(final org.omg.CORBA.portable.InputStream in) {
		return narrow(in.read_Object());
	}

	public static void write(final org.omg.CORBA.portable.OutputStream _out,
			final exemploAula.corbaClasses.Property s) {
		_out.write_Object(s);
	}

	public static exemploAula.corbaClasses.Property narrow(
			final java.lang.Object obj) {
		if (obj instanceof exemploAula.corbaClasses.Property) {
			return (exemploAula.corbaClasses.Property) obj;
		} else if (obj instanceof org.omg.CORBA.Object) {
			return narrow((org.omg.CORBA.Object) obj);
		}
		throw new org.omg.CORBA.BAD_PARAM("Failed to narrow in helper");
	}

	public static exemploAula.corbaClasses.Property narrow(
			final org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		try {
			return (exemploAula.corbaClasses.Property) obj;
		} catch (ClassCastException c) {
			if (obj._is_a("IDL:exemploAula/corbaClasses/Property:1.0")) {
				exemploAula.corbaClasses._PropertyStub stub;
				stub = new exemploAula.corbaClasses._PropertyStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl) obj)
						._get_delegate());
				return stub;
			}
		}
		throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
	}

	public static exemploAula.corbaClasses.Property unchecked_narrow(
			final org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		try {
			return (exemploAula.corbaClasses.Property) obj;
		} catch (ClassCastException c) {
			exemploAula.corbaClasses._PropertyStub stub;
			stub = new exemploAula.corbaClasses._PropertyStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl) obj)
					._get_delegate());
			return stub;
		}
	}
}
