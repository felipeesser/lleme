package br.pucrio.inf.catfwk.model;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;


import org.xml.sax.SAXException;

import br.pucrio.inf.geocat.GeoImageDesc;
import jmunit.framework.cldc11.TestCase;

public class FileSystemDirectoryTest extends TestCase {

    private FileSystemDirectory repository = null;

    public FileSystemDirectoryTest(int totalOfTests, String name) {
        super(totalOfTests, name);
    }

    public void setUp() throws Throwable {
        super.setUp();
        repository = new FileSystemDirectory(".");
    }

    public void tearDown() {
        super.tearDown();
        repository = null;
        System.gc();
    }

    public void testListUriInvalidDirectory() {
        String[] list = null;
        try {
            repository = new FileSystemDirectory(".\\inexistentDir");
            list = repository.listURI();
            fail("Não sinalizou exceção");
        } catch (IOException e) {
            assertTrue(true);
        }
        assertNull(list);
    }

    public void testListUriNullDirectory() {
        String[] list = null;
        try {
            repository = new FileSystemDirectory(null);
            list = repository.listURI();
            fail("Não sinalizou exceção");
        } catch (IOException e) {
            assertTrue(true);
        }
        assertNull(list);
    }

    /*
     * Test method for
     * 'inf.puc_rio.geocat.ADLGazeteerService.getContent(String)'
     */
    public void testGetContentInvalidURL() {
        GeoImageDesc content = null;
        try {
            // invalid gazetteer URL
            repository = new FileSystemDirectory(".\\inexistentDir");
            content = (GeoImageDesc) repository.getDescription(repository.getUrl()
                    + "\\resource1.xml");
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
    public void testGetContentNullURI() {
        GeoImageDesc content = null;
        repository = new FileSystemDirectory(".\\");
        try {
            content = (GeoImageDesc) repository.getDescription(null);
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

    public void test(int testNumber) throws Throwable {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
