package corbaObjects.scs;

/**
 * corbaObjects/scs/NodeLookupOperations.java . Generated by the IDL-to-Java
 * compiler (portable), version "3.2" from deployment.idl Sexta-feira, 9 de
 * Dezembro de 2005 18h26min28s BRST
 */

public interface NodeLookupOperations {
	corbaObjects.scs.NodeDescription getNode(String name);

	corbaObjects.scs.NodeDescription[] getNodes(
			corbaObjects.scs.Property[] props);

	corbaObjects.scs.NodeDescription[] getAllNodes();
} // interface NodeLookupOperations
