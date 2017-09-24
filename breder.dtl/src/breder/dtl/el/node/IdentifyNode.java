package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

/**
 * Nó de Identificador
 * 
 * 
 * @author Bernardo Breder
 */
public class IdentifyNode extends Node {

	/**
	 * Construtor padrão
	 * 
	 * @param token
	 *            nome do identificador
	 */
	public IdentifyNode(Token token) {
		super(token);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.getToken().image;
	}

}
