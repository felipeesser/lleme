package br.pucrio.inf;

import jmunit.framework.cldc11.Test;
import jmunit.framework.cldc11.TestRunner;

public class MyTestRunner extends TestRunner {

    public MyTestRunner(int delay) {
        super(delay);
    }

    public MyTestRunner(String name, int delay) {
        super(name, delay);
    }

    protected Test getNestedTest() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
