package corbaObjects.scs;

/**
 * corbaObjects/scs/_ComponentRepositoryStub.java . Generated by the IDL-to-Java
 * compiler (portable), version "3.2" from deployment.idl Sexta-feira, 9 de
 * Dezembro de 2005 18h26min28s BRST
 */

@SuppressWarnings("serial")
public class _ComponentRepositoryStub extends org.omg.CORBA.portable.ObjectImpl
		implements corbaObjects.scs.ComponentRepository {

	public void install(corbaObjects.scs.ComponentId id, String entry_point,
			boolean shared, byte[] file, String help_info)
			throws corbaObjects.scs.ComponentAlreadyInstalled,
			corbaObjects.scs.IOException {
		org.omg.CORBA.portable.InputStream $in = null;
		try {
			org.omg.CORBA.portable.OutputStream $out = _request("install", true);
			corbaObjects.scs.ComponentIdHelper.write($out, id);
			$out.write_string(entry_point);
			$out.write_boolean(shared);
			corbaObjects.scs.OctetSeqHelper.write($out, file);
			$out.write_string(help_info);
			$in = _invoke($out);
			return;
		} catch (org.omg.CORBA.portable.ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			if (_id
					.equals("IDL:corbaObjects/scs/ComponentAlreadyInstalled:1.0"))
				throw corbaObjects.scs.ComponentAlreadyInstalledHelper
						.read($in);
			else if (_id.equals("IDL:corbaObjects/scs/IOException:1.0"))
				throw corbaObjects.scs.IOExceptionHelper.read($in);
			else
				throw new org.omg.CORBA.MARSHAL(_id);
		} catch (org.omg.CORBA.portable.RemarshalException $rm) {
			install(id, entry_point, shared, file, help_info);
		} finally {
			_releaseReply($in);
		}
	} // install

	public void uninstall(corbaObjects.scs.ComponentId id)
			throws corbaObjects.scs.ComponentNotInstalled,
			corbaObjects.scs.IOException {
		org.omg.CORBA.portable.InputStream $in = null;
		try {
			org.omg.CORBA.portable.OutputStream $out = _request("uninstall",
					true);
			corbaObjects.scs.ComponentIdHelper.write($out, id);
			$in = _invoke($out);
			return;
		} catch (org.omg.CORBA.portable.ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			if (_id.equals("IDL:corbaObjects/scs/ComponentNotInstalled:1.0"))
				throw corbaObjects.scs.ComponentNotInstalledHelper.read($in);
			else if (_id.equals("IDL:corbaObjects/scs/IOException:1.0"))
				throw corbaObjects.scs.IOExceptionHelper.read($in);
			else
				throw new org.omg.CORBA.MARSHAL(_id);
		} catch (org.omg.CORBA.portable.RemarshalException $rm) {
			uninstall(id);
		} finally {
			_releaseReply($in);
		}
	} // uninstall

	public void copy(corbaObjects.scs.ComponentId id,
			corbaObjects.scs.ComponentRepository rep)
			throws corbaObjects.scs.ComponentAlreadyInstalled,
			corbaObjects.scs.ComponentNotInstalled {
		org.omg.CORBA.portable.InputStream $in = null;
		try {
			org.omg.CORBA.portable.OutputStream $out = _request("copy", true);
			corbaObjects.scs.ComponentIdHelper.write($out, id);
			corbaObjects.scs.ComponentRepositoryHelper.write($out, rep);
			$in = _invoke($out);
			return;
		} catch (org.omg.CORBA.portable.ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			if (_id
					.equals("IDL:corbaObjects/scs/ComponentAlreadyInstalled:1.0"))
				throw corbaObjects.scs.ComponentAlreadyInstalledHelper
						.read($in);
			else if (_id
					.equals("IDL:corbaObjects/scs/ComponentNotInstalled:1.0"))
				throw corbaObjects.scs.ComponentNotInstalledHelper.read($in);
			else
				throw new org.omg.CORBA.MARSHAL(_id);
		} catch (org.omg.CORBA.portable.RemarshalException $rm) {
			copy(id, rep);
		} finally {
			_releaseReply($in);
		}
	} // copy

	public byte[] getComponentFile(corbaObjects.scs.ComponentId id)
			throws corbaObjects.scs.ComponentNotInstalled,
			corbaObjects.scs.IOException {
		org.omg.CORBA.portable.InputStream $in = null;
		try {
			org.omg.CORBA.portable.OutputStream $out = _request(
					"getComponentFile", true);
			corbaObjects.scs.ComponentIdHelper.write($out, id);
			$in = _invoke($out);
			byte $result[] = corbaObjects.scs.OctetSeqHelper.read($in);
			return $result;
		} catch (org.omg.CORBA.portable.ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			if (_id.equals("IDL:corbaObjects/scs/ComponentNotInstalled:1.0"))
				throw corbaObjects.scs.ComponentNotInstalledHelper.read($in);
			else if (_id.equals("IDL:corbaObjects/scs/IOException:1.0"))
				throw corbaObjects.scs.IOExceptionHelper.read($in);
			else
				throw new org.omg.CORBA.MARSHAL(_id);
		} catch (org.omg.CORBA.portable.RemarshalException $rm) {
			return getComponentFile(id);
		} finally {
			_releaseReply($in);
		}
	} // getComponentFile

	public corbaObjects.scs.ComponentDescription getComponentDescription(
			corbaObjects.scs.ComponentId id)
			throws corbaObjects.scs.ComponentNotInstalled {
		org.omg.CORBA.portable.InputStream $in = null;
		try {
			org.omg.CORBA.portable.OutputStream $out = _request(
					"getComponentDescription", true);
			corbaObjects.scs.ComponentIdHelper.write($out, id);
			$in = _invoke($out);
			corbaObjects.scs.ComponentDescription $result = corbaObjects.scs.ComponentDescriptionHelper
					.read($in);
			return $result;
		} catch (org.omg.CORBA.portable.ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			if (_id.equals("IDL:corbaObjects/scs/ComponentNotInstalled:1.0"))
				throw corbaObjects.scs.ComponentNotInstalledHelper.read($in);
			throw new org.omg.CORBA.MARSHAL(_id);
		} catch (org.omg.CORBA.portable.RemarshalException $rm) {
			return getComponentDescription(id);
		} finally {
			_releaseReply($in);
		}
	} // getComponentDescription

	public corbaObjects.scs.ComponentDescription[] getInstalledComponents() {
		org.omg.CORBA.portable.InputStream $in = null;
		try {
			org.omg.CORBA.portable.OutputStream $out = _request(
					"getInstalledComponents", true);
			$in = _invoke($out);
			corbaObjects.scs.ComponentDescription $result[] = corbaObjects.scs.ComponentDescriptionSeqHelper
					.read($in);
			return $result;
		} catch (org.omg.CORBA.portable.ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			throw new org.omg.CORBA.MARSHAL(_id);
		} catch (org.omg.CORBA.portable.RemarshalException $rm) {
			return getInstalledComponents();
		} finally {
			_releaseReply($in);
		}
	} // getInstalledComponents

	// Type-specific CORBA::Object operations
	private static String[] __ids = { "IDL:corbaObjects/scs/ComponentRepository:1.0" };

	public String[] _ids() {
		return __ids.clone();
	}

	private void readObject(java.io.ObjectInputStream s)
			throws java.io.IOException {
		String str = s.readUTF();
		String[] args = null;
		java.util.Properties props = null;
		org.omg.CORBA.Object obj = org.omg.CORBA.ORB.init(args, props)
				.string_to_object(str);
		org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)
				._get_delegate();
		_set_delegate(delegate);
	}

	private void writeObject(java.io.ObjectOutputStream s)
			throws java.io.IOException {
		String[] args = null;
		java.util.Properties props = null;
		String str = org.omg.CORBA.ORB.init(args, props).object_to_string(this);
		s.writeUTF(str);
	}
} // class _ComponentRepositoryStub
