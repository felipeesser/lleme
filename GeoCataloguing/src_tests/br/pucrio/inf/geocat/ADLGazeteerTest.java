package br.pucrio.inf.geocat;

import br.pucrio.inf.catfwk.model.InvalidDatasetDescException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import jmunit.framework.cldc11.TestCase;
import org.xml.sax.SAXException;

public class ADLGazeteerTest extends TestCase {

    private ADLGazeteer library = null;

    public ADLGazeteerTest(int totalOfTests, String name) {
        super(totalOfTests, name);
    }

    public void setUp() throws Throwable {
        super.setUp();
        library = new ADLGazeteer(
                "http://middleware.alexandria.ucsb.edu/gaz/adlgaz/dispatch");
    }

    public void tearDown() {
        super.tearDown();
        library = null;
        System.gc();
    }

    /*
     * Test method for
     * 'inf.puc_rio.geocat.ADLGazeteerService.getContent(String)'
     */
    public void testGetContentValid() {
        GeoImageDesc content = null;
        OOISO19115GeoImage image = new OOISO19115GeoImage();
        image.setUri("teste.xml");
        image.setLeftUpperCornerPoint(-43.26, -22.891);
        image.setRightLowerCornerPoint(-43.203, -22.932);
        try {
            content = (GeoImageDesc) library.getDescription(image);
        } catch (InvalidDatasetDescException e) {
            fail("InvalidSourceContentException");
        } catch (ParserConfigurationException e) {
            fail("ParserConfigurationException");
        } catch (SAXException e) {
            fail("SAXException");
        } catch (IOException e) {
            fail("IOException");
        }
        assertTrue(content.getDataSets().length == 17);
    }

    /*
     * Test method for
     * 'inf.puc_rio.geocat.ADLGazeteerService.getContent(String)'
     */
    public void testGetContentEmptyBoundingbox() {
        GeoImageInterface content = null;
        OOISO19115GeoImage image = new OOISO19115GeoImage();
        image.setUri("teste.xml");
        image.setLeftUpperCornerPoint(-42.8, -22.8);
        image.setRightLowerCornerPoint(-42.8, -22.8);
        try {
            content = (GeoImageInterface) library.getDescription(image);
        } catch (InvalidDatasetDescException e) {
            fail("InvalidSourceContentException");
        } catch (ParserConfigurationException e) {
            fail("ParserConfigurationException");
        } catch (SAXException e) {
            fail("SAXException");
        } catch (IOException e) {
            fail("IOException");
        }
        assertNull(content);
    }

    /*
     * Test method for
     * 'inf.puc_rio.geocat.ADLGazeteerService.getContent(String)'
     */
    public void testGetContentInvalidBoundingbox() {
        GeoImageInterface content = null;
        OOISO19115GeoImage image = new OOISO19115GeoImage();
        image.setUri("teste.xml");
        image.setLeftUpperCornerPoint(1234345, -22.8);
        image.setRightLowerCornerPoint(-42.8, -22.8);
        try {
            content = (GeoImageInterface) library.getDescription(image);
            fail("Não sinalizou exceção");
        } catch (InvalidDatasetDescException e) {
            fail("InvalidSourceContentException");
        } catch (ParserConfigurationException e) {
            fail("ParserConfigurationException");
        } catch (SAXException e) {
            fail("SAXException");
        } catch (IOException e) {
            assertTrue(true);
        }
        assertNull(content);
    }

    /*
     * Test method for
     * 'inf.puc_rio.geocat.ADLGazeteerService.getContent(String)'
     */
    public void testGetContentWithoutImage() {
        GeoImageInterface content = null;
        try {
            content = (GeoImageInterface) library.getDescription(null);
        } catch (InvalidDatasetDescException e) {
            fail("InvalidSourceContentException");
        } catch (ParserConfigurationException e) {
            fail("ParserConfigurationException");
        } catch (SAXException e) {
            fail("SAXException");
        } catch (IOException e) {
            fail("SAXException");
        }
        assertNull(content);
    }

    /*
     * Test method for
     * 'inf.puc_rio.geocat.ADLGazeteerService.getContent(String)'
     */
    public void testGetContentInvalidURL() {
        GeoImageInterface content = null;
        OOISO19115GeoImage image = new OOISO19115GeoImage();
        image.setUri("teste.xxx");
        image.setLeftUpperCornerPoint(-42.8, -22.2);
        image.setRightLowerCornerPoint(-42.2, -22.8);
        try {
            // invalid gazetteer URL
            library = new ADLGazeteer(null);
            content = (GeoImageInterface) library.getDescription(image);
            fail("Não sinalizou exceção");
        } catch (InvalidDatasetDescException e) {
            fail("InvalidDatasetContentException");
        } catch (ParserConfigurationException e) {
            fail("ParserConfigurationException");
        } catch (SAXException e) {
            fail("SAXException");
        } catch (IOException e) {
            assertTrue(true);
        }
        assertNull(content);
    }

    public void test(int testNumber) throws Throwable {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
