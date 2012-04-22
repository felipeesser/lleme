package br.pucrio.inf.geocat;

import iso.iso19115.spatial_representation.MD_Georectified;
import iso.iso19139.dataset.DS_DataSet;
import jmunit.framework.cldc11.TestCase;

public class OOISO19115GeoImageTest extends TestCase {

    public OOISO19115GeoImageTest(int totalOfTests, String name) {
        super(totalOfTests, name);
    }

    public void setUp() throws Throwable {
        super.setUp();
    }

    public void tearDown() {
        super.tearDown();
    }

    /*
     * Test method for
     * 'br.pucrio.inf.geocat.OOISO19115GeoImage.aggregateDataset(Dataset)'
     */
    public void testAggregateDataset() {
        OOISO19115GeoImage image = new OOISO19115GeoImage();
        OOISO19115GeoImage features = new OOISO19115GeoImage();

        image.setIdentifier("identificador");
        image.setName("nome");
        image.setUri("image.xml");
        image.setLeftUpperCornerPointX(1);
        image.setLeftUpperCornerPointY(2);
        image.setRightLowerCornerPointX(3);
        image.setRightLowerCornerPointY(4);

        features.setIdentifier("feature1");
        features.setName("nomeFeature1");
        features.setUri("#1");
        features.setLeftUpperCornerPointX(1);
        features.setLeftUpperCornerPointY(2);
        features.setRightLowerCornerPointX(3);
        features.setRightLowerCornerPointY(4);

        features.incrementDatasetCapacity();
        features.setIdentifier("feature2");
        features.setName("nomeFeature2");
        features.setUri("#2");
        features.setLeftUpperCornerPointX(1);
        features.setLeftUpperCornerPointY(2);
        features.setRightLowerCornerPointX(3);
        features.setRightLowerCornerPointY(4);

        image.aggregateDescription(features);
        DS_DataSet[] dataset = image.getDataSets();
        assertEquals(dataset[0].has[0].fileIdentifier, "identificador");
        assertEquals(dataset[0].has[0].metadataStandardName, "nome");
        assertEquals(dataset[0].has[0].dataSetURI, "image.xml");
        assertEquals(((MD_Georectified) dataset[0].has[0].spatialRepresentationInfo[0]).cornerPoints[0].x, 0);
        assertEquals(((MD_Georectified) dataset[0].has[0].spatialRepresentationInfo[0]).cornerPoints[0].y, 0);
        assertEquals(((MD_Georectified) dataset[0].has[0].spatialRepresentationInfo[0]).cornerPoints[2].x, 0);
        assertEquals(((MD_Georectified) dataset[0].has[0].spatialRepresentationInfo[0]).cornerPoints[2].y, 0);

        assertEquals(dataset[1].has[0].fileIdentifier, "feature2");
        assertEquals(dataset[1].has[0].metadataStandardName, "nomeFeature2");
        assertEquals(dataset[1].has[0].dataSetURI, "#2");
        assertEquals(((MD_Georectified) dataset[1].has[0].spatialRepresentationInfo[0]).cornerPoints[0].x, 0);
        assertEquals(((MD_Georectified) dataset[1].has[0].spatialRepresentationInfo[0]).cornerPoints[0].y, 0);
        assertEquals(((MD_Georectified) dataset[1].has[0].spatialRepresentationInfo[0]).cornerPoints[2].x, 0);
        assertEquals(((MD_Georectified) dataset[1].has[0].spatialRepresentationInfo[0]).cornerPoints[2].y, 0);

        assertEquals(dataset[2].has[0].fileIdentifier, "feature1");
        assertEquals(dataset[2].has[0].metadataStandardName, "nomeFeature1");
        assertEquals(dataset[2].has[0].dataSetURI, "#1");
        assertEquals(((MD_Georectified) dataset[2].has[0].spatialRepresentationInfo[0]).cornerPoints[0].x, 0);
        assertEquals(((MD_Georectified) dataset[2].has[0].spatialRepresentationInfo[0]).cornerPoints[0].y, 0);
        assertEquals(((MD_Georectified) dataset[2].has[0].spatialRepresentationInfo[0]).cornerPoints[2].x, 0);
        assertEquals(((MD_Georectified) dataset[2].has[0].spatialRepresentationInfo[0]).cornerPoints[2].y, 0);
    }

    public void test(int testNumber) throws Throwable {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
