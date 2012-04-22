package br.pucrio.inf.geocat;

import br.pucrio.inf.catfwk.model.InvalidDatasetDescException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import jmunit.framework.cldc11.TestCase;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLParserTest extends TestCase {

    private XMLParser parser = null;

    public XMLParserTest(int totalOfTests, String name) {
        super(totalOfTests, name);
    }

    public void setUp() throws Throwable {
        super.setUp();
        parser = new XMLParser(new ISO19115ImageBuilder());
    }

    public void tearDown() {
        super.tearDown();
        parser = null;
        System.gc();
    }

    /*
     * Test method for 'inf.puc_rio.geocat.GeoXMLReader.parse(InputSource)'
     */
    public final void testParseWithValidFile() {
        MetadataElement[] elements = null;
        try {
            elements = parser.parse(new InputSource("testResource1.xml"));
        } catch (InvalidDatasetDescException e) {
            fail("Exceção incorreta");
        } catch (ParserConfigurationException e) {
            fail("Exceção incorreta");
        } catch (SAXException e) {
            fail("Exceção incorreta");
        } catch (IOException e) {
            fail("Exceção incorreta");
        }
        assertTrue(elements[0].getQname().equals("resource"));
        assertTrue(elements[1].getQname().equals("identifier"));
        assertTrue(elements[1].getValue().equals("LandSat.2005110100:00:00000"));
        assertTrue(elements[2].getQname().equals("bounding-box"));
        assertTrue(elements[3].getQname().equals("gml:coord"));
        assertTrue(elements[4].getQname().equals("gml:X"));
        assertTrue(elements[4].getValue().equals("-42.8"));
        assertTrue(elements[5].getQname().equals("gml:Y"));
        assertTrue(elements[5].getValue().equals("-22.2"));
        assertTrue(elements[6].getQname().equals("gml:coord"));
        assertTrue(elements[7].getQname().equals("gml:X"));
        assertTrue(elements[7].getValue().equals("-42.2"));
        assertTrue(elements[8].getQname().equals("gml:Y"));
        assertTrue(elements[8].getValue().equals("-22.8"));
    }

    /*
     * Test method for 'inf.puc_rio.geocat.GeoXMLReader.parse(InputSource)'
     */
    public final void testParseWithInvalidContent() {
        MetadataElement[] elements = null;
        try {
            elements = parser.parse(new InputSource("testResource2.xml"));
            fail("Não sinalizou exceção");
        } catch (InvalidDatasetDescException e) {
            assertTrue(true);
        } catch (ParserConfigurationException e) {
            fail("ParserConfigurationException");
        } catch (SAXException e) {
            fail("SAXException");
        } catch (IOException e) {
            fail("IOException");
        }
        assertNull(elements);
    }

    /*
     * Test method for 'inf.puc_rio.geocat.GeoXMLReader.parse(InputSource)'
     */
    public final void testParseWithInvalidFile() {
        MetadataElement[] elements = null;
        InputSource in = new InputSource("#########");
        try {
            elements = parser.parse(in);
            fail("Não sinalizou exceção");
        } catch (InvalidDatasetDescException e) {
            fail("Invalid exception InvalidSourceContentException");
        } catch (ParserConfigurationException e) {
            fail("Invalid exception ParserConfigurationException");
        } catch (SAXException e) {
            fail("Invalid exception SAXException");
        } catch (IOException e) {
            assertTrue(true);
        }
        assertNull(elements);
    }

    /*
     * Test method for 'inf.puc_rio.geocat.GeoXMLReader.parse(InputSource)'
     */
    public final void testParseWithNullFile() {
        MetadataElement[] elements = null;
        String filename = null;
        InputSource in = new InputSource(filename);
        try {
            elements = parser.parse(in);
        } catch (InvalidDatasetDescException e) {
            fail("Invalid exception InvalidSourceContentException");
        } catch (ParserConfigurationException e) {
            fail("Invalid exception ParserConfigurationException");
        } catch (SAXException e) {
            fail("Invalid exception SAXException");
        } catch (IOException e) {
            assertTrue(elements == null);
        }
    }

    public void test(int testNumber) throws Throwable {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
