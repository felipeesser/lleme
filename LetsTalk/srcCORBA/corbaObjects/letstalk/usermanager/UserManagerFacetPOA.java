package corbaObjects.letstalk.usermanager;

/**
 * corbaObjects/letstalk/usermanager/UserManagerFacetPOA.java . Generated by the
 * IDL-to-Java compiler (portable), version "3.2" from letstalk.idl Sexta-feira,
 * 9 de Dezembro de 2005 18h26min29s BRST
 */

public abstract class UserManagerFacetPOA extends
		org.omg.PortableServer.Servant implements
		corbaObjects.letstalk.usermanager.UserManagerFacetOperations,
		org.omg.CORBA.portable.InvokeHandler {

	// Constructors

	private static java.util.Hashtable _methods = new java.util.Hashtable();

	static {
		_methods.put("subscribe", new java.lang.Integer(0));
		_methods.put("connect", new java.lang.Integer(1));
		_methods.put("desconnect", new java.lang.Integer(2));
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
		case 0: // corbaObjects/letstalk/usermanager/UserManagerFacet/subscribe
		{
			String login = in.read_string();
			String password = in.read_string();
			corbaObjects.letstalk.usermanager.enum_type $result = null;
			$result = this.subscribe(login, password);
			out = $rh.createReply();
			corbaObjects.letstalk.usermanager.enum_typeHelper.write(out,
					$result);
			break;
		}

		case 1: // corbaObjects/letstalk/usermanager/UserManagerFacet/connect
		{
			String login = in.read_string();
			String password = in.read_string();
			corbaObjects.letstalk.usermanager.enum_type $result = null;
			$result = this.connect(login, password);
			out = $rh.createReply();
			corbaObjects.letstalk.usermanager.enum_typeHelper.write(out,
					$result);
			break;
		}

		case 2: // corbaObjects/letstalk/usermanager/UserManagerFacet/desconnect
		{
			String login = in.read_string();
			corbaObjects.letstalk.usermanager.enum_type $result = null;
			$result = this.desconnect(login);
			out = $rh.createReply();
			corbaObjects.letstalk.usermanager.enum_typeHelper.write(out,
					$result);
			break;
		}

		default:
			throw new org.omg.CORBA.BAD_OPERATION(0,
					org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
		}

		return out;
	} // _invoke

	// Type-specific CORBA::Object operations
	private static String[] __ids = { "IDL:corbaObjects/letstalk/usermanager/UserManagerFacet:1.0" };

	public String[] _all_interfaces(org.omg.PortableServer.POA poa,
			byte[] objectId) {
		return __ids.clone();
	}

	public UserManagerFacet _this() {
		return UserManagerFacetHelper.narrow(super._this_object());
	}

	public UserManagerFacet _this(org.omg.CORBA.ORB orb) {
		return UserManagerFacetHelper.narrow(super._this_object(orb));
	}

} // class UserManagerFacetPOA
