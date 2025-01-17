package corbaObjects.scs;

/**
 * corbaObjects/scs/NodeRegisterPOA.java . Generated by the IDL-to-Java compiler
 * (portable), version "3.2" from deployment.idl Sexta-feira, 9 de Dezembro de
 * 2005 18h26min28s BRST
 */

public abstract class NodeRegisterPOA extends org.omg.PortableServer.Servant
		implements corbaObjects.scs.NodeRegisterOperations,
		org.omg.CORBA.portable.InvokeHandler {

	// Constructors

	private static java.util.Hashtable _methods = new java.util.Hashtable();

	static {
		_methods.put("register", new java.lang.Integer(0));
		_methods.put("unregister", new java.lang.Integer(1));
	}

	public org.omg.CORBA.portable.OutputStream _invoke(String $method,
			org.omg.CORBA.portable.InputStream in,
			org.omg.CORBA.portable.ResponseHandler $rh) {
		org.omg.CORBA.portable.OutputStream out = null;
		java.lang.Integer __method = (java.lang.Integer) _methods.get($method);
		if (__method == null)
			throw new org.omg.CORBA.BAD_OPERATION(0,
					org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

		switch (__method.intValue()) {
		case 0: // corbaObjects/scs/NodeRegister/register
		{
			corbaObjects.scs.IComponent node = corbaObjects.scs.IComponentHelper
					.read(in);
			corbaObjects.scs.Property props[] = corbaObjects.scs.PropertySeqHelper
					.read(in);
			this.register(node, props);
			out = $rh.createReply();
			break;
		}

		case 1: // corbaObjects/scs/NodeRegister/unregister
		{
			try {
				corbaObjects.scs.IComponent node = corbaObjects.scs.IComponentHelper
						.read(in);
				this.unregister(node);
				out = $rh.createReply();
			} catch (corbaObjects.scs.ComponentNotFound $ex) {
				out = $rh.createExceptionReply();
				corbaObjects.scs.ComponentNotFoundHelper.write(out, $ex);
			}
			break;
		}

		default:
			throw new org.omg.CORBA.BAD_OPERATION(0,
					org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
		}

		return out;
	} // _invoke

	// Type-specific CORBA::Object operations
	private static String[] __ids = { "IDL:corbaObjects/scs/NodeRegister:1.0" };

	public String[] _all_interfaces(org.omg.PortableServer.POA poa,
			byte[] objectId) {
		return __ids.clone();
	}

	public NodeRegister _this() {
		return NodeRegisterHelper.narrow(super._this_object());
	}

	public NodeRegister _this(org.omg.CORBA.ORB orb) {
		return NodeRegisterHelper.narrow(super._this_object(orb));
	}

} // class NodeRegisterPOA
