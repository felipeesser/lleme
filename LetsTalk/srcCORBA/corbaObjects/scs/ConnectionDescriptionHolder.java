package corbaObjects.scs;

/**
 * corbaObjects/scs/ConnectionDescriptionHolder.java . Generated by the
 * IDL-to-Java compiler (portable), version "3.2" from scs.idl Sexta-feira, 9 de
 * Dezembro de 2005 18h26min27s BRST
 */

public final class ConnectionDescriptionHolder implements
		org.omg.CORBA.portable.Streamable {
	public corbaObjects.scs.ConnectionDescription value = null;

	public ConnectionDescriptionHolder() {
	}

	public ConnectionDescriptionHolder(
			corbaObjects.scs.ConnectionDescription initialValue) {
		value = initialValue;
	}

	public void _read(org.omg.CORBA.portable.InputStream i) {
		value = corbaObjects.scs.ConnectionDescriptionHelper.read(i);
	}

	public void _write(org.omg.CORBA.portable.OutputStream o) {
		corbaObjects.scs.ConnectionDescriptionHelper.write(o, value);
	}

	public org.omg.CORBA.TypeCode _type() {
		return corbaObjects.scs.ConnectionDescriptionHelper.type();
	}

}
