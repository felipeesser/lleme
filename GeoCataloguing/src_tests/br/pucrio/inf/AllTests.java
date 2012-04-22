package br.pucrio.inf;

import br.pucrio.inf.catfwk.model.FileSystemDirectoryTest;
import br.pucrio.inf.geocat.*;
import jmunit.framework.cldc11.Test;
import jmunit.framework.cldc11.TestResult;
import jmunit.framework.cldc11.TestSuite;

public class AllTests extends TestResult {

    public static void main(String[] args) {
        (new MyTestRunner(0)).run(new AllTests());
    }

    public Test suite() {
        TestSuite suite = new TestSuite("Hotspots tests");
        // $JUnit-BEGIN$
        suite.add(new OOISO19115GeoImageTest(1, ""));
        suite.add(new XMLParserTest(1, ""));
        suite.add(new ISO19115ImageBuilderTest(1, ""));
        suite.add(new ISO19115ADLFeaturesBuilderTest(1, ""));
        suite.add(new FileSystemDirectoryTest(1, ""));
        suite.add(new ADLGazeteerTest(1, ""));
        // $JUnit-END$
        return suite;
    }
}
