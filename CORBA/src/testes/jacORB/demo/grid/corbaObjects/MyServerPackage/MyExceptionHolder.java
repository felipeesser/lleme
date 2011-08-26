package testes.jacORB.demo.grid.corbaObjects.MyServerPackage;

/**
 * Generated from IDL definition of exception "MyException"
 * 
 * @author JacORB IDL compiler
 */

public final class MyExceptionHolder implements
		org.omg.CORBA.portable.Streamable {
	public testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyException value;

	public MyExceptionHolder() {
	}

	public MyExceptionHolder(
			final testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyException initial) {
		value = initial;
	}

	public org.omg.CORBA.TypeCode _type() {
		return testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyExceptionHelper
				.type();
	}

	public void _read(final org.omg.CORBA.portable.InputStream _in) {
		value = testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyExceptionHelper
				.read(_in);
	}

	public void _write(final org.omg.CORBA.portable.OutputStream _out) {
		testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyExceptionHelper
				.write(_out, value);
	}
}
