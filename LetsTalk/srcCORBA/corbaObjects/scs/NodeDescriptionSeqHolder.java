package corbaObjects.scs;

/**
 * corbaObjects/scs/NodeDescriptionSeqHolder.java . Generated by the IDL-to-Java
 * compiler (portable), version "3.2" from deployment.idl Sexta-feira, 9 de
 * Dezembro de 2005 18h26min28s BRST
 */

public final class NodeDescriptionSeqHolder implements
		org.omg.CORBA.portable.Streamable {
	public corbaObjects.scs.NodeDescription value[] = null;

	public NodeDescriptionSeqHolder() {
	}

	public NodeDescriptionSeqHolder(
			corbaObjects.scs.NodeDescription[] initialValue) {
		value = initialValue;
	}

	public void _read(org.omg.CORBA.portable.InputStream i) {
		value = corbaObjects.scs.NodeDescriptionSeqHelper.read(i);
	}

	public void _write(org.omg.CORBA.portable.OutputStream o) {
		corbaObjects.scs.NodeDescriptionSeqHelper.write(o, value);
	}

	public org.omg.CORBA.TypeCode _type() {
		return corbaObjects.scs.NodeDescriptionSeqHelper.type();
	}

}
