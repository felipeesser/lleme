package lleme.corba.testes.javaORB.StockObjects;

/**
 * StockObjects/StockPOATie.java . Generated by the IDL-to-Java compiler
 * (portable), version "3.1" from stock.idl S�bado, 17 de Setembro de 2005
 * 14h07min45s BRT
 */

public class StockPOATie extends StockPOA {

	// Constructors

	public StockPOATie(lleme.corba.testes.javaORB.StockObjects.StockOperations delegate) {
		this._impl = delegate;
	}

	public StockPOATie(lleme.corba.testes.javaORB.StockObjects.StockOperations delegate,
			org.omg.PortableServer.POA poa) {
		this._impl = delegate;
		this._poa = poa;
	}

	public lleme.corba.testes.javaORB.StockObjects.StockOperations _delegate() {
		return this._impl;
	}

	public void _delegate(lleme.corba.testes.javaORB.StockObjects.StockOperations delegate) {
		this._impl = delegate;
	}

	public org.omg.PortableServer.POA _default_POA() {
		if (_poa != null) {
			return _poa;
		}
		return super._default_POA();
	}

	// Returns the current stock quote.
	public lleme.corba.testes.javaORB.StockObjects.Quote get_quote()
			throws lleme.corba.testes.javaORB.StockObjects.Unknown {
		return _impl.get_quote();
	} // get_quote

	// *** put your operation for setting the quote here
	public void set_quote(lleme.corba.testes.javaORB.StockObjects.Quote stock_quote) {
		_impl.set_quote(stock_quote);
	} // set_quote

	// Provides the stock description, e.g. company name.
	public String description() {
		return _impl.description();
	} // description

	private lleme.corba.testes.javaORB.StockObjects.StockOperations _impl;

	private org.omg.PortableServer.POA _poa;

} // class StockPOATie
