package br.pucrio.inf.geocat;

import br.pucrio.inf.catfwk.model.InvalidDatasetDescException;
import jmunit.framework.cldc11.TestCase;

public class ISO19115ImageBuilderTest extends TestCase {

    private ISO19115ImageBuilder builder = null;

    public ISO19115ImageBuilderTest(int totalOfTests, String name) {
        super(totalOfTests, name);
    }

    public void setUp() throws Throwable {
        super.setUp();
        builder = new ISO19115ImageBuilder();
    }

    public void tearDown() {
        super.tearDown();
        builder = null;
        System.gc();
    }

    /*
     * Test method for 'inf.puc_rio.geocat.ImageMetadataBuilder.build(Object)'
     */
    public final void testBuildWithMissingIdentifierElement() {
        MetadataElement[] elements = new MetadataElement[9];
        MetadataElement element = new MetadataElement(null, null, "gml:X", null);
        element.setValue("15");
        elements[4] = element;
        element = new MetadataElement(null, null, "gml:Y", null);
        element.setValue("32");
        elements[5] = element;
        element = new MetadataElement(null, null, "gml:X", null);
        element.setValue("22");
        elements[7] = element;
        element = new MetadataElement(null, null, "gml:Y", null);
        element.setValue("67");
        elements[8] = element;
        try {
            builder.build(elements);
        } catch (NumberFormatException e) {
            fail("Exceção incorreta");
        } catch (InvalidDatasetDescException e) {
            assertNull(builder.getDatasetDescription());
        }
    }

    public final void testBuildWithInvalidCoordinate() {
        MetadataElement[] elements = new MetadataElement[9];
        MetadataElement element = new MetadataElement(null, null, "identifier",
                null);
        element.setValue("afsdaf");
        elements[1] = element;
        element = new MetadataElement(null, null, "gml:X", null);
        element.setValue("15a");
        elements[4] = element;
        element = new MetadataElement(null, null, "gml:Y", null);
        element.setValue("32");
        elements[5] = element;
        element = new MetadataElement(null, null, "gml:X", null);
        element.setValue("22");
        elements[7] = element;
        element = new MetadataElement(null, null, "gml:Y", null);
        element.setValue("67");
        elements[8] = element;
        try {
            builder.build(elements);
            fail("Não sinalizou exceção");
        } catch (NumberFormatException e) {
            assertTrue(true);
        } catch (InvalidDatasetDescException e) {
            fail("Exceção incorreta");
        }
        assertNull(builder.getDatasetDescription());
    }

    public final void testBuildWithNullElements() {
        MetadataElement[] elements = null;
        try {
            builder.build(elements);
            fail("Não sinalizou exceção");
        } catch (NumberFormatException e) {
            fail("Exceção incorreta");
        } catch (InvalidDatasetDescException e) {
            assertTrue(true);
        }
        assertNull(builder.getDatasetDescription());
    }

    public final void testBuildWithNullValues() {
        MetadataElement[] elements = new MetadataElement[9];
        MetadataElement element = new MetadataElement(null, null, "identifier",
                null);
        element.setValue(null);
        elements[1] = element;
        element = new MetadataElement(null, null, "gml:X", null);
        element.setValue(null);
        elements[4] = element;
        element = new MetadataElement(null, null, "gml:Y", null);
        element.setValue(null);
        elements[5] = element;
        element = new MetadataElement(null, null, "gml:X", null);
        element.setValue(null);
        elements[7] = element;
        element = new MetadataElement(null, null, "gml:Y", null);
        element.setValue(null);
        elements[8] = null;
        try {
            builder.build(elements);
            fail("Não sinalizou exceção");
        } catch (NumberFormatException e) {
            assertTrue(true);
        } catch (InvalidDatasetDescException e) {
            fail("Exceção incorreta");
        }
        assertNull(builder.getDatasetDescription());
    }

    public final void testBuildWithValidElements() {
        String identifier = "aaa";
        Double coordX1 = new Double(15.0);
        Double coordY1 = new Double(32.0);
        Double coordX2 = new Double(15.0);
        Double coordY2 = new Double(32.0);
        MetadataElement[] elements = new MetadataElement[9];
        MetadataElement element = new MetadataElement(null, null, "identifier",
                null);
        element.setValue(identifier);
        elements[1] = element;
        element = new MetadataElement(null, null, "gml:X", null);
        element.setValue(coordX1.toString());
        elements[4] = element;
        element = new MetadataElement(null, null, "gml:Y", null);
        element.setValue(coordY1.toString());
        elements[5] = element;
        element = new MetadataElement(null, null, "gml:X", null);
        element.setValue(coordX2.toString());
        elements[7] = element;
        element = new MetadataElement(null, null, "gml:Y", null);
        element.setValue(coordY2.toString());
        elements[8] = element;

        OOISO19115GeoImage expectedImage = new OOISO19115GeoImage();
        expectedImage.setIdentifier(elements[1].getValue());
        expectedImage.setLeftUpperCornerPoint(coordX1.doubleValue(), coordY1.doubleValue());
        expectedImage.setRightLowerCornerPoint(coordX2.doubleValue(), coordY2.doubleValue());
        try {
            builder.build(elements);
        } catch (NumberFormatException e) {
            fail("Exceção incorreta");
        } catch (InvalidDatasetDescException e) {
            fail("Exceção incorreta");
        }
        OOISO19115GeoImage obj = (OOISO19115GeoImage) builder.getDatasetDescription();
        assertEquals(expectedImage.getUri(), obj.getUri());
        assertEquals(expectedImage.getIdentifier(), obj.getIdentifier());
        assertEquals(expectedImage.getCornerPointsX(0),
                obj.getCornerPointsX(0));
        assertEquals(expectedImage.getCornerPointsY(0),
                obj.getCornerPointsY(0));
        assertEquals(expectedImage.getCornerPointsX(2),
                obj.getCornerPointsX(2));
        assertEquals(expectedImage.getCornerPointsY(2),
                obj.getCornerPointsY(2));
    }

    public void test(int testNumber) throws Throwable {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
