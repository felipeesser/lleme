/* Generated by Together */

package br.pucrio.inf.catfwk.appmodel;

import java.io.FileNotFoundException;
import java.io.IOException;


abstract public interface Application {

	public abstract Document createDocument(String filename);

	/**
	 * Cria novo documento
	 * 
	 * @version 1.0
	 * @since 1.0
	 * @param filename
	 *            nome do arquivo no qual ser� serializado o documento
	 */
	public abstract Document newDocument(String filename)
			throws FileNotFoundException;

	/**
	 * Carrega documento serializado.
	 * 
	 * @version 1.0
	 * @since 1.0
	 * @param filename
	 *            nome do arquivo no qual est� serializado o documento
	 * @return documento recuperado
	 * @exception IOException
	 * @exception ClassNotFoundException
	 */
	public abstract Document loadDocument(String filename) throws IOException,
			ClassNotFoundException;

	/**
	 * Recupera documento pelo nome do arquivo.
	 * 
	 * @version 1.0
	 * @since 1.0
	 * @param filename
	 *            nome do arquivo
	 * @return documento recuperado
	 */
	public abstract Document getDocument(String filename);
}
