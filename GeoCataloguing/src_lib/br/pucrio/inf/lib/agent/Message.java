/* Generated by Together */

package br.pucrio.inf.lib.agent;

/**
 * @author Luiz Andr�
 * @version 1.0
 * @since 1.0
 * @alias Message
 * @stereotype abstract*/
public abstract class Message {
	public Message(Object body) {
		this.body = body;
	}

	/**
	 * @version 1.0
	 * @since 1.0
	 * @return conte�do da mensagem
	 */
	public Object getBody() {
		return body;
	}

	/**
	 * @version 1.0
	 * @since 1.0
	 * @param body
	 *            conte�do da mensagem
	 */
	public void setBody(Object body) {
		this.body = body;
	}

	private Object body = null;

}
