package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

/**
 * Representa um nó da linguagem
 * 
 * 
 * @author Bernardo Breder
 */
public abstract class Node {

	/** Token */
	private final Token token;

	/**
	 * Construtor padrão
	 * 
	 * @param token
	 */
	public Node(Token token) {
		super();
		this.token = token;
	}

	/**
	 * Retorna
	 * 
	 * @return token
	 */
	public Token getToken() {
		return token;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.toString(0);
	}

	/**
	 * Imprime o texto formatado
	 * 
	 * @param level
	 * @return texto formatado
	 */
	public String toString(int level) {
		StringBuilder sb = new StringBuilder();
		for (int n = 0; n < level; n++) {
			sb.append("\t");
		}
		return sb.toString() + this.getToken().image;
	}

	/**
	 * Retorna o proprio
	 * 
	 * @param <E>
	 * @return proprio
	 */
	@SuppressWarnings("unchecked")
	public <E extends Node> E cast() {
		return (E) this;
	}

}
