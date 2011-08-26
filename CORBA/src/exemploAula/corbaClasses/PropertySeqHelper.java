package exemploAula.corbaClasses;

/**
 * Generated from IDL definition of alias "PropertySeq"
 * 
 * @author JacORB IDL compiler
 */

public final class PropertySeqHelper {
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert(org.omg.CORBA.Any any,
			exemploAula.corbaClasses.Property[] s) {
		any.type(type());
		write(any.create_output_stream(), s);
	}

	public static exemploAula.corbaClasses.Property[] extract(
			final org.omg.CORBA.Any any) {
		return read(any.create_input_stream());
	}

	public static org.omg.CORBA.TypeCode type() {
		if (_type == null) {
			_type = org.omg.CORBA.ORB
					.init()
					.create_alias_tc(
							exemploAula.corbaClasses.PropertySeqHelper.id(),
							"PropertySeq",
							org.omg.CORBA.ORB
									.init()
									.create_sequence_tc(
											0,
											org.omg.CORBA.ORB
													.init()
													.create_interface_tc(
															"IDL:exemploAula/corbaClasses/Property:1.0",
															"Property")));
		}
		return _type;
	}

	public static String id() {
		return "IDL:exemploAula/corbaClasses/PropertySeq:1.0";
	}

	public static exemploAula.corbaClasses.Property[] read(
			final org.omg.CORBA.portable.InputStream _in) {
		exemploAula.corbaClasses.Property[] _result;
		int _l_result0 = _in.read_long();
		_result = new exemploAula.corbaClasses.Property[_l_result0];
		for (int i = 0; i < _result.length; i++) {
			_result[i] = exemploAula.corbaClasses.PropertyHelper.read(_in);
		}

		return _result;
	}

	public static void write(final org.omg.CORBA.portable.OutputStream _out,
			exemploAula.corbaClasses.Property[] _s) {

		_out.write_long(_s.length);
		for (int i = 0; i < _s.length; i++) {
			exemploAula.corbaClasses.PropertyHelper.write(_out, _s[i]);
		}

	}
}
