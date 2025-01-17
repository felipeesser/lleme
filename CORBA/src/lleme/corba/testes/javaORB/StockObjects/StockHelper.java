package lleme.corba.testes.javaORB.StockObjects;

/**
 * StockObjects/StockHelper.java . Generated by the IDL-to-Java compiler
 * (portable), version "3.1" from stock.idl S�bado, 17 de Setembro de 2005
 * 14h14min39s BRT
 */

abstract public class StockHelper {
	private static String _id = "IDL:StockObjects/Stock:1.0";

	public static void insert(org.omg.CORBA.Any a,
			lleme.corba.testes.javaORB.StockObjects.Stock that) {
		org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
		a.type(type());
		write(out, that);
		a.read_value(out.create_input_stream(), type());
	}

	public static lleme.corba.testes.javaORB.StockObjects.Stock extract(org.omg.CORBA.Any a) {
		return read(a.create_input_stream());
	}

	private static org.omg.CORBA.TypeCode __typeCode = null;

	synchronized public static org.omg.CORBA.TypeCode type() {
		if (__typeCode == null) {
			__typeCode = org.omg.CORBA.ORB.init().create_interface_tc(
					lleme.corba.testes.javaORB.StockObjects.StockHelper.id(), "Stock");
		}
		return __typeCode;
	}

	public static String id() {
		return _id;
	}

	public static lleme.corba.testes.javaORB.StockObjects.Stock read(
			org.omg.CORBA.portable.InputStream istream) {
		return narrow(istream.read_Object(_StockStub.class));
	}

	public static void write(org.omg.CORBA.portable.OutputStream ostream,
			lleme.corba.testes.javaORB.StockObjects.Stock value) {
		ostream.write_Object(value);
	}

	public static lleme.corba.testes.javaORB.StockObjects.Stock narrow(
			org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		else if (obj instanceof lleme.corba.testes.javaORB.StockObjects.Stock)
			return (lleme.corba.testes.javaORB.StockObjects.Stock) obj;
		else if (!obj._is_a(id()))
			throw new org.omg.CORBA.BAD_PARAM();
		else {
			org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)
					._get_delegate();
			lleme.corba.testes.javaORB.StockObjects._StockStub stub = new lleme.corba.testes.javaORB.StockObjects._StockStub();
			stub._set_delegate(delegate);
			return stub;
		}
	}

}
