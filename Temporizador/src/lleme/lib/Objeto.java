package lleme.lib;

import java.io.Serializable;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import lleme.lib.observer.SubjectImpl;

public abstract class Objeto extends SubjectImpl implements Serializable {
	private BD bd = null;

	private Statement statement = null;

	private HashMap msgDados = new HashMap();

	private ArrayList msgOperacoes = new ArrayList();

	private boolean retrieveDone = false;

	public void initFields() {
		this.retrieveDone = false;
	}

	public BD getBd() {
		return bd;
	}

	public void setBd(BD bd) {
		this.bd = bd;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public HashMap getMsgDados() {
		return msgDados;
	}

	public ArrayList getMsgOperacoes() {
		return msgOperacoes;
	}

	public String getAllMsgDados() {
		String msg = new String(""); //$NON-NLS-1$
		Collection c = getMsgDados().values();
		Iterator i = c.iterator();
		while (i.hasNext()) {
			msg = msg.concat((String) i.next() + "\n"); //$NON-NLS-1$
		}
		return msg;
	}

	public String getAllMsgOperacoes() {
		String msg = new String(""); //$NON-NLS-1$
		Iterator i = getMsgOperacoes().iterator();
		while (i.hasNext()) {
			msg = msg.concat((String) i.next() + "\n"); //$NON-NLS-1$
		}
		return msg;
	}

	public void clearAllMsgDados() {
		this.msgDados = new HashMap();
	}

	public void clearAllMsgOperacoes() {
		this.msgOperacoes = new ArrayList();
	}

	public void clearAllMsg() {
		clearAllMsgDados();
		clearAllMsgOperacoes();
	}

	public boolean isDestroyEnable() {
		return retrieveDone;
	}

	public boolean isUpdateEnable() {
		return retrieveDone;
	}

	public boolean isRetrieveDone() {
		return retrieveDone;
	}

	public void setRetrieveDone(boolean retrieveDone) {
		this.retrieveDone = retrieveDone;
	}

	public abstract void retrieve();

	public abstract boolean update();

	public abstract void persist();

	public abstract void destroy();

	public void errorRecovery() {
		try {
			bd.getConnection().rollback();
			statement.close();
		} catch (Throwable excp) {
			msgOperacoes.add("Recupera��o do erro anterior mal sucedida: " //$NON-NLS-1$
					+ excp.getMessage() + "."); //$NON-NLS-1$
		}
	}
}