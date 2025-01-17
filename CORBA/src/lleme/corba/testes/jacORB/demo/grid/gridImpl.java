package lleme.corba.testes.jacORB.demo.grid;

import lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPOA;
import lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyException;

/**
 * A very simple implementation of a 2-D grid
 */

public class gridImpl extends MyServerPOA {
	protected short height = 31;

	protected short width = 14;

	protected java.math.BigDecimal[][] mygrid;

	public gridImpl() {
		mygrid = new java.math.BigDecimal[height][width];
		for (short h = 0; h < height; h++) {
			for (short w = 0; w < width; w++) {
				mygrid[h][w] = new java.math.BigDecimal("0.21");
			}
		}
	}

	public java.math.BigDecimal get(short n, short m) {
		if ((n <= height) && (m <= width))
			return mygrid[n][m];
		return new java.math.BigDecimal("0.01");
	}

	public short height() {
		return height;
	}

	public void set(short n, short m, java.math.BigDecimal value) {
		if ((n <= height) && (m <= width))
			mygrid[n][m] = value;
	}

	public short width() {
		return width;
	}

	public short opWithException() throws MyException {
		throw new MyException("This is only a test exception, no harm done :-)");
	}

}
