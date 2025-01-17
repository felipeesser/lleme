/* Generated by Together */

package br.pucrio.inf.geocat;

import br.pucrio.inf.catfwk.model.DatasetDescription;
import br.pucrio.inf.catfwk.model.InvalidDatasetDescException;
import br.pucrio.inf.catfwk.model.RepositoryDescBuilder;

/**
 * @author Luiz Andr�
 * @version 1.0
 * @since 1.0
 * @alias ISO19115ImageBuilder*/
public class ISO19115ImageBuilder extends RepositoryDescBuilder {
	/**
	 * @supplierCardinality 0..1*/
	private OOISO19115GeoImage imageDescription = null;

	/**
	 * Constr�i estrutura de calaloga��o da imagem extra�da de um meio de
	 * armazenamento.
	 * 
	 * @version 1.0
	 * @since 1.0
	 * @param metadataElements
	 *            vetor de chaves XML (MetadataElements[]) que representam a
	 *            imagem extra�da de um meio de armazenamento.
	 */
	public void build(Object metadataElements)
			throws InvalidDatasetDescException, NumberFormatException {
		this.imageDescription = null;
		boolean fail = false;
		MetadataElement[] elements = null;
		OOISO19115GeoImage _imageDescription = null;

		if (metadataElements != null) {
			elements = (MetadataElement[]) metadataElements;
			_imageDescription = new OOISO19115GeoImage();
			if (elements[1] != null && elements[1].getQname() == "identifier") {
				_imageDescription.setIdentifier(elements[1].getValue());
				try {
					if (elements[4] != null
							&& elements[4].getQname() == "gml:X"
							&& elements[5] != null
							&& elements[5].getQname() == "gml:Y") {
						_imageDescription.setLeftUpperCornerPoint((new Double(
								elements[4].getValue())).doubleValue(),
								(new Double(elements[5].getValue()))
										.doubleValue());
						if (elements[7] != null
								&& elements[7].getQname() == "gml:X"
								&& elements[8] != null
								&& elements[8].getQname() == "gml:Y")
							_imageDescription.setRightLowerCornerPoint(
									(new Double(elements[7].getValue()))
											.doubleValue(), (new Double(
											elements[8].getValue()))
											.doubleValue());
						else
							fail = true;
					} else
						fail = true;
				} catch (NullPointerException e) {
					throw new NumberFormatException("Null coordinate value");
				}
			} else
				fail = true;

		} else
			fail = true;

		if (fail) {
			throw new InvalidDatasetDescException(
					"Building InformationResource: invalid source content");
		}
		this.imageDescription = _imageDescription;
	}

	public DatasetDescription getDatasetDescription() {
		return imageDescription;
	}
}
