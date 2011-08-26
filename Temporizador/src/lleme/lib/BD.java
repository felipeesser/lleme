package lleme.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BD {

	private String driver = null;

	private String url = null;

	private String user = null;

	private String password = null;

	private Connection connection;

	public BD(String driver, String bd, String user, String pass)
			throws ClassNotFoundException, SQLException {
		setDriver(driver);
		setUrl(bd);
		setUser(user);
		setPassword(pass);
		connect(driver, bd, user, pass);
	}

	public Connection getConnection() {
		return connection;
	}

	private void connect(String driver, String bd, String user, String pass)
			throws ClassNotFoundException, SQLException {
		System.out.println("Abrindo conex�o......"); //$NON-NLS-1$
		Class.forName(driver);
		connection = DriverManager.getConnection(bd, user, pass);
		connection.setAutoCommit(false);
		System.out.println("Conex�o aberta."); //$NON-NLS-1$
	}

	private void disconnect() {
		System.out.println("Fechando conex�o......"); //$NON-NLS-1$
		try {
			connection.rollback();
			connection.close();
		} catch (SQLException excp) {
			System.out.println(excp);
		}
		System.out.println("Conex�o fechada."); //$NON-NLS-1$
	}

	/**
	 * @return Returns the driver.
	 */
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Returns the url.
	 */
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return Returns the user.
	 */
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void finalize() throws Throwable {
		disconnect();
		super.finalize();
	}
}