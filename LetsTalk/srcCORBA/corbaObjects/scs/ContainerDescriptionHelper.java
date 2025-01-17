package corbaObjects.scs;

/**
 * corbaObjects/scs/ContainerDescriptionHelper.java . Generated by the
 * IDL-to-Java compiler (portable), version "3.2" from deployment.idl
 * Sexta-feira, 9 de Dezembro de 2005 18h26min28s BRST
 */

abstract public class ContainerDescriptionHelper {
	private static String _id = "IDL:corbaObjects/scs/ContainerDescription/ContainerDescription:1.0";

	public static void insert(org.omg.CORBA.Any a,
			corbaObjects.scs.ContainerDescription that) {
		org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
		a.type(type());
		write(out, that);
		a.read_value(out.create_input_stream(), type());
	}

	public static corbaObjects.scs.ContainerDescription extract(
			org.omg.CORBA.Any a) {
		return read(a.create_input_stream());
	}

	private static org.omg.CORBA.TypeCode __typeCode = null;

	private static boolean __active = false;

	synchronized public static org.omg.CORBA.TypeCode type() {
		if (__typeCode == null) {
			synchronized (org.omg.CORBA.TypeCode.class) {
				if (__typeCode == null) {
					if (__active) {
						return org.omg.CORBA.ORB.init()
								.create_recursive_tc(_id);
					}
					__active = true;
					org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember[3];
					org.omg.CORBA.TypeCode _tcOf_members0 = null;
					_tcOf_members0 = corbaObjects.scs.IComponentHelper.type();
					_members0[0] = new org.omg.CORBA.StructMember("container",
							_tcOf_members0, null);
					_tcOf_members0 = org.omg.CORBA.ORB.init().create_string_tc(
							0);
					_members0[1] = new org.omg.CORBA.StructMember(
							"container_name", _tcOf_members0, null);
					_tcOf_members0 = corbaObjects.scs.IComponentHelper.type();
					_members0[2] = new org.omg.CORBA.StructMember(
							"execution_node", _tcOf_members0, null);
					__typeCode = org.omg.CORBA.ORB.init().create_struct_tc(
							corbaObjects.scs.ContainerDescriptionHelper.id(),
							"ContainerDescription", _members0);
					__active = false;
				}
			}
		}
		return __typeCode;
	}

	public static String id() {
		return _id;
	}

	public static corbaObjects.scs.ContainerDescription read(
			org.omg.CORBA.portable.InputStream istream) {
		corbaObjects.scs.ContainerDescription value = new corbaObjects.scs.ContainerDescription();
		value.container = corbaObjects.scs.IComponentHelper.read(istream);
		value.container_name = istream.read_string();
		value.execution_node = corbaObjects.scs.IComponentHelper.read(istream);
		return value;
	}

	public static void write(org.omg.CORBA.portable.OutputStream ostream,
			corbaObjects.scs.ContainerDescription value) {
		corbaObjects.scs.IComponentHelper.write(ostream, value.container);
		ostream.write_string(value.container_name);
		corbaObjects.scs.IComponentHelper.write(ostream, value.execution_node);
	}

}
