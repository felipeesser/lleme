package br.pucrio.inf.geocat;

import br.pucrio.inf.catfwk.model.InvalidDatasetDescException;
import iso.iso19115.spatial_representation.MD_Georectified;
import iso.iso19139.dataset.DS_DataSet;
import jmunit.framework.cldc11.TestCase;

public class ISO19115ADLFeaturesBuilderTest extends TestCase {

    private ISO19115ADLFeaturesBuilder builder = null;

    public ISO19115ADLFeaturesBuilderTest(int totalOfTests, String name) {
        super(totalOfTests, name);
    }

    public void setUp() throws Throwable {
        super.setUp();
        builder = new ISO19115ADLFeaturesBuilder();
    }

    public void tearDown() {
        super.tearDown();
        builder = null;
        System.gc();
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

    /*
     * Test method for
     * 'inf.puc_rio.geocat.GazeteerFeaturesBuilder.build(Object)'
     */
    public final void testBuildWithValidElements() {
        MetadataElement[] elements = createValidMetadataElements();

        OOISO19115GeoImage expectedImage = new OOISO19115GeoImage();
        expectedImage.setIdentifier("adlgaz-1-1433782-76");
        expectedImage.setName("Guapiacu - Brazil");
        expectedImage.setLeftUpperCornerPoint(-42.7667, -22.45);
        expectedImage.setRightLowerCornerPoint(-42.7667, -22.45);

        expectedImage.incrementDatasetCapacity();
        expectedImage.setIdentifier("adlgaz-1-1412669-12");
        expectedImage.setName("Bacaxa, Rio - Brazil");
        expectedImage.setLeftUpperCornerPoint(-42.35, -22.7333);
        expectedImage.setRightLowerCornerPoint(-42.35, -22.7333);

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
        assertEquals(expectedImage.getName(), obj.getName());
        assertEquals(expectedImage.getCornerPointsX(0), obj.getCornerPointsX(0));
        assertEquals(expectedImage.getCornerPointsY(0), obj.getCornerPointsY(0));
        assertEquals(expectedImage.getCornerPointsX(2), obj.getCornerPointsX(2));
        assertEquals(expectedImage.getCornerPointsY(2), obj.getCornerPointsY(2));

        DS_DataSet[] datasetExpected = expectedImage.getDataSets();
        DS_DataSet[] datasetObj = obj.getDataSets();

        assertEquals(datasetExpected[1].has[0].metadataStandardName,
                datasetObj[1].has[0].metadataStandardName);
        assertEquals(datasetExpected[1].has[0].metadataStandardName,
                datasetObj[1].has[0].metadataStandardName);
        assertEquals(
                ((MD_Georectified) datasetExpected[1].has[0].spatialRepresentationInfo[0]).cornerPoints[0].x,
                ((MD_Georectified) datasetObj[1].has[0].spatialRepresentationInfo[0]).cornerPoints[0].x);
        assertEquals(
                ((MD_Georectified) datasetExpected[1].has[0].spatialRepresentationInfo[0]).cornerPoints[0].y,
                ((MD_Georectified) datasetObj[1].has[0].spatialRepresentationInfo[0]).cornerPoints[0].y);
        assertEquals(
                ((MD_Georectified) datasetExpected[1].has[0].spatialRepresentationInfo[0]).cornerPoints[2].x,
                ((MD_Georectified) datasetObj[1].has[0].spatialRepresentationInfo[0]).cornerPoints[2].x);
        assertEquals(
                ((MD_Georectified) datasetExpected[1].has[0].spatialRepresentationInfo[0]).cornerPoints[2].y,
                ((MD_Georectified) datasetObj[1].has[0].spatialRepresentationInfo[0]).cornerPoints[2].y);

    }

    private MetadataElement[] createValidMetadataElements() {
        int i = 0;
        MetadataElement[] elements = new MetadataElement[100];
        MetadataElement element = new MetadataElement(null, null,
                "gazetteer-service", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "query-response", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "standard-reports", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "gazetteer-standard-report",
                null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "identifier", null);
        element.setValue("adlgaz-1-1433782-76");
        elements[i++] = element;
        element = new MetadataElement(null, null, "codes", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "code", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "place-status", null);
        element.setValue("current");
        elements[i++] = element;
        element = new MetadataElement(null, null, "display-name", null);
        element.setValue("Guapiacu - Brazil");
        elements[i++] = element;
        element = new MetadataElement(null, null, "names", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "name", null);
        element.setValue("Guapiassu");
        elements[i++] = element;
        element = new MetadataElement(null, null, "bounding-box", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:coord", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:X", null);
        element.setValue("-42.7667");
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:Y", null);
        element.setValue("-22.45");
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:coord", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:X", null);
        element.setValue("-42.7667");
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:Y", null);
        element.setValue("-22.45");
        elements[i++] = element;
        element = new MetadataElement(null, null, "footprints", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "footprint", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:Point", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:coord", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:X", null);
        element.setValue("-42.7667");
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:Y", null);
        element.setValue("-22.45");
        element = new MetadataElement(null, null, "classes", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "class", null);
        element.setValue("populated places");
        elements[i++] = element;
        element = new MetadataElement(null, null, "relationships", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "relationship", null);
        element.setValue(null);
        elements[i++] = element;

        element = new MetadataElement(null, null, "gazetteer-standard-report",
                null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "identifier", null);
        element.setValue("adlgaz-1-1412669-12");
        elements[i++] = element;
        element = new MetadataElement(null, null, "codes", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "code", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "place-status", null);
        element.setValue("current");
        elements[i++] = element;
        element = new MetadataElement(null, null, "display-name", null);
        element.setValue("Bacaxa, Rio - Brazil");
        elements[i++] = element;
        element = new MetadataElement(null, null, "names", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "name", null);
        element.setValue("Bacaxa, Rio");
        elements[i++] = element;
        element = new MetadataElement(null, null, "bounding-box", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:coord", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:X", null);
        element.setValue("-42.35");
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:Y", null);
        element.setValue("-22.7333");
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:coord", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:X", null);
        element.setValue("-42.35");
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:Y", null);
        element.setValue("-22.7333");
        elements[i++] = element;
        element = new MetadataElement(null, null, "footprints", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "footprint", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:Point", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:coord", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:X", null);
        element.setValue("-42.35");
        elements[i++] = element;
        element = new MetadataElement(null, null, "gml:Y", null);
        element.setValue("-22.7333");
        element = new MetadataElement(null, null, "classes", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "class", null);
        element.setValue("streams");
        elements[i++] = element;
        element = new MetadataElement(null, null, "relationships", null);
        element.setValue(null);
        elements[i++] = element;
        element = new MetadataElement(null, null, "relationship", null);
        element.setValue(null);
        elements[i++] = element;
        return elements;
    }

    public void test(int testNumber) throws Throwable {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
