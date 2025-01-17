package corbaObjects.scs;

/**
 * corbaObjects/scs/ExecutionNodePOA.java . Generated by the IDL-to-Java
 * compiler (portable), version "3.2" from deployment.idl Sexta-feira, 9 de
 * Dezembro de 2005 18h26min28s BRST
 */

public abstract class ExecutionNodePOA extends org.omg.PortableServer.Servant
		implements corbaObjects.scs.ExecutionNodeOperations,
		org.omg.CORBA.portable.InvokeHandler {

	// Constructors

	private static java.util.Hashtable _methods = new java.util.Hashtable();

	static {
		_methods.put("_get_name", new java.lang.Integer(0));
		_methods.put("startContainer", new java.lang.Integer(1));
		_methods.put("getContainer", new java.lang.Integer(2));
		_methods.put("getContainers", new java.lang.Integer(3));
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
		case 0: // corbaObjects/scs/ExecutionNode/_get_name
		{
			String $result = null;
			$result = this.name();
			out = $rh.createReply();
			out.write_string($result);
			break;
		}

		case 1: // corbaObjects/scs/ExecutionNode/startContainer
		{
			try {
				String container_name = in.read_string();
				corbaObjects.scs.IComponent $result = null;
				$result = this.startContainer(container_name);
				out = $rh.createReply();
				corbaObjects.scs.IComponentHelper.write(out, $result);
			} catch (corbaObjects.scs.ContainerAlreadyExists $ex) {
				out = $rh.createExceptionReply();
				corbaObjects.scs.ContainerAlreadyExistsHelper.write(out, $ex);
			} catch (corbaObjects.scs.InternalError $ex) {
				out = $rh.createExceptionReply();
				corbaObjects.scs.InternalErrorHelper.write(out, $ex);
			}
			break;
		}

		case 2: // corbaObjects/scs/ExecutionNode/getContainer
		{
			String container_name = in.read_string();
			corbaObjects.scs.IComponent $result = null;
			$result = this.getContainer(container_name);
			out = $rh.createReply();
			corbaObjects.scs.IComponentHelper.write(out, $result);
			break;
		}

		case 3: // corbaObjects/scs/ExecutionNode/getContainers
		{
			corbaObjects.scs.ContainerDescription $result[] = null;
			$result = this.getContainers();
			out = $rh.createReply();
			corbaObjects.scs.ContainerDescriptionSeqHelper.write(out, $result);
			break;
		}

		default:
			throw new org.omg.CORBA.BAD_OPERATION(0,
					org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
		}

		return out;
	} // _invoke

	// Type-specific CORBA::Object operations
	private static String[] __ids = { "IDL:corbaObjects/scs/ExecutionNode:1.0" };

	public String[] _all_interfaces(org.omg.PortableServer.POA poa,
			byte[] objectId) {
		return __ids.clone();
	}

	public ExecutionNode _this() {
		return ExecutionNodeHelper.narrow(super._this_object());
	}

	public ExecutionNode _this(org.omg.CORBA.ORB orb) {
		return ExecutionNodeHelper.narrow(super._this_object(orb));
	}

} // class ExecutionNodePOA
