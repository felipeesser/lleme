package corbaObjects.letstalk.usermanager;

/**
 * corbaObjects/letstalk/usermanager/enum_type.java . Generated by the
 * IDL-to-Java compiler (portable), version "3.2" from letstalk.idl Sexta-feira,
 * 9 de Dezembro de 2005 18h26min29s BRST
 */

public class enum_type implements org.omg.CORBA.portable.IDLEntity {
	private int __value;

	private static int __size = 3;

	private static corbaObjects.letstalk.usermanager.enum_type[] __array = new corbaObjects.letstalk.usermanager.enum_type[__size];

	public static final int _OK = 0;

	public static final corbaObjects.letstalk.usermanager.enum_type OK = new corbaObjects.letstalk.usermanager.enum_type(
			_OK);

	public static final int _WRONGLOGIN = 1;

	public static final corbaObjects.letstalk.usermanager.enum_type WRONGLOGIN = new corbaObjects.letstalk.usermanager.enum_type(
			_WRONGLOGIN);

	public static final int _ERROR = 2;

	public static final corbaObjects.letstalk.usermanager.enum_type ERROR = new corbaObjects.letstalk.usermanager.enum_type(
			_ERROR);

	public int value() {
		return __value;
	}

	public static corbaObjects.letstalk.usermanager.enum_type from_int(int value) {
		if (value >= 0 && value < __size)
			return __array[value];
		throw new org.omg.CORBA.BAD_PARAM();
	}

	protected enum_type(int value) {
		__value = value;
		__array[__value] = this;
	}
} // class enum_type
