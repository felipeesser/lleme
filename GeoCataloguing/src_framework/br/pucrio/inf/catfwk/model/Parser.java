/* Generated by Together */

package br.pucrio.inf.catfwk.model;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.pucrio.inf.geocat.MetadataElement;

/**
 * @author Luiz Andr�
 * @version 1.0
 * @since 1.0
 * @alias Parser
 * @stereotype abstract*/
abstract public class Parser extends DefaultHandler {
	public Parser(Builder builder) {
		this.builder = builder;
	}

	public abstract MetadataElement[] parse(InputSource source)
			throws ParserConfigurationException, SAXException, IOException,
			InvalidDatasetDescException;

	/**
	 * @return Returns the builder.
	 */
	public Builder getBuilder() {
		return builder;
	}

	/**
	 * @associates <{Builder}>
	 * @label uses
	 * @labelDirection forward*/
	private Builder builder = null;
}
