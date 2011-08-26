package lleme.lib;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public abstract class Colecao extends AbstractTableModel implements
		TableModelListener {
	private BD bd = null;

	private Statement statement = null;

	private ResultSet resultSet = null;

	private ResultSetMetaData metaData = null;

	private String query = null;

	private String[] columnNames = {};

	private Vector rows = new Vector();

	private int pos = 0;

	private HashMap msgOperacoes = null;

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

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public ResultSetMetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(ResultSetMetaData metaData) {
		this.metaData = metaData;
	}

	public Vector getRows() {
		return rows;
	}

	public void setRows(Vector rows) {
		this.rows = rows;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = (pos < 0 ? 0 : (pos > getRowCount() ? this.pos : pos));
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public HashMap getMsgOperacoes() {
		return msgOperacoes;
	}

	public void clearAllMsg() {
		this.msgOperacoes = new HashMap();
	}

	public String getAllMsgOperacoes() {
		String msg = new String(""); //$NON-NLS-1$
		Collection c = getMsgOperacoes().values();
		Iterator i = c.iterator();
		while (i.hasNext()) {
			msg = msg.concat((String) i.next() + "\n"); //$NON-NLS-1$
		}
		return msg;
	}

	public void executeQuery() {
		try {
			resultSet = getStatement().executeQuery(getQuery());
			metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			columnNames = new String[numberOfColumns];
			// Get the column names and cache them.
			// Then we can close the connection.
			for (int column = 0; column < numberOfColumns; column++) {
				columnNames[column] = metaData.getColumnLabel(column + 1);
			}
			// Get all rows.
			rows = new Vector();
			while (resultSet.next()) {
				Vector newRow = new Vector();
				for (int i = 1; i <= getColumnCount(); i++) {
					newRow.addElement(resultSet.getObject(i));
				}
				rows.addElement(newRow);
			}
			// close(); Need to copy the metaData, bug in jdbc:odbc driver.
			bd.getConnection().commit();
			fireTableChanged(null); // Tell the listeners a new table has
			// arrived.
		} catch (SQLException ex) {
			System.err.println(ex);
		}
	}

	public void close() throws SQLException {
		resultSet.close();
		statement.close();
	}

	public void finalize() throws Throwable {
		close();
		super.finalize();
	}

	public void tableChanged(TableModelEvent e) {
		fireTableChanged(e);
	}

	// ////////////////////////////////////////////////////////////////////////
	//
	// Implementation of the TableModel Interface
	//
	// ////////////////////////////////////////////////////////////////////////

	// MetaData

	public String getColumnName(int column) {
		if (columnNames[column] != null) {
			return columnNames[column];
		}
		return ""; //$NON-NLS-1$
	}

	public Class getColumnClass(int column) {
		int type;
		try {
			type = metaData.getColumnType(column + 1);
		} catch (SQLException e) {
			return super.getColumnClass(column);
		}
		switch (type) {
		case Types.CHAR:
		case Types.VARCHAR:
		case Types.LONGVARCHAR:
			return String.class;

		case Types.BIT:
			return Boolean.class;

		case Types.TINYINT:
		case Types.SMALLINT:
		case Types.INTEGER:
			return Integer.class;

		case Types.BIGINT:
			return Long.class;

		case Types.FLOAT:
		case Types.DOUBLE:
			return Double.class;

		case Types.DATE:
			return java.sql.Date.class;

		default:
			return Object.class;
		}
	}

	public boolean isCellEditable(int column) {
		try {
			return metaData.isWritable(column + 1);
		} catch (SQLException e) {
			return false;
		}
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	// Data methods
	public int getRowCount() {
		return rows.size();
	}

	public java.lang.Object getValueAt(int aRow, int aColumn) {
		Vector row = (Vector) rows.elementAt(aRow);
		return row.elementAt(aColumn);
	}

	public java.lang.Object getValueAt(int aRow, String aColumn) {
		if (aRow < getRowCount()) {
			for (int i = 0; i < columnNames.length; i++) {
				if (getColumnName(i).equals(aColumn)) {
					return (getValueAt(aRow, i) == null ? "null      " //$NON-NLS-1$
							: getValueAt(aRow, i));
				}
			}

			return "null      "; //$NON-NLS-1$
		}
		return "&nbsp;    "; //$NON-NLS-1$
	}

	public String dbRepresentation(int column, java.lang.Object value) {

		int type;

		if (value == null) {
			return "null"; //$NON-NLS-1$
		}
		try {
			type = metaData.getColumnType(column + 1);
		} catch (SQLException e) {
			return value.toString();
		}
		switch (type) {
		case Types.INTEGER:
		case Types.DOUBLE:
		case Types.FLOAT:
			return value.toString();
		case Types.BIT:
			return ((Boolean) value).booleanValue() ? "1" : "0"; //$NON-NLS-1$//$NON-NLS-2$
		case Types.DATE:
			return value.toString(); // This will need some conversion.
		default:
			return "\"" + value.toString() + "\""; //$NON-NLS-1$//$NON-NLS-2$
		}

	}

	public void setValueAt(Object value, int row, int column) {
		try {
			String tableName = metaData.getTableName(column + 1);
			// Some of the drivers seem buggy, tableName should not be null.
			if (tableName == null) {
				System.out.println("Table name returned null."); //$NON-NLS-1$
			}
			String columnName = getColumnName(column);
			String query = "update " + tableName + " set " + columnName + " = " //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
					+ dbRepresentation(column, value) + " where "; //$NON-NLS-1$
			// We don't have a model of the schema so we don't know the
			// primary keys or which columns to lock on. To demonstrate
			// that editing is possible, we'll just lock on everything.
			for (int col = 0; col < getColumnCount(); col++) {
				String colName = getColumnName(col);
				if (colName.equals("")) { //$NON-NLS-1$
					continue;
				}
				if (col != 0) {
					query = query + " and "; //$NON-NLS-1$
				}
				query = query + colName + " = " //$NON-NLS-1$
						+ dbRepresentation(col, getValueAt(row, col));
			}
			System.out.println(query);
			System.out.println("Not sending update to database"); //$NON-NLS-1$
			// statement.executeQuery(query);
		} catch (SQLException e) {
			// e.printStackTrace();
			System.err.println("Update failed"); //$NON-NLS-1$
		}
		Vector dataRow = (Vector) rows.elementAt(row);
		dataRow.setElementAt(value, column);
	}
}