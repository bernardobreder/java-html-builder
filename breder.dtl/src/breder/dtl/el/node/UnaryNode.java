package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

/**
 * Nó unario
 * 
 * 
 * @author Bernardo Breder
 */
public abstract class UnaryNode extends ExpressionNode {

	/** Valor a esquerda */
	private Node left;

	/**
	 * Construtor padrão
	 * 
	 * @param token
	 * @param left
	 */
	public UnaryNode(Token token, Node left) {
		super(token);
		this.left = left;
	}

	/**
	 * Retorna
	 * 
	 * @return left
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * @param left
	 * @return owner
	 */
	public UnaryNode setLeft(Node left) {
		this.left = left;
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.getToken().image + this.getLeft().toString();
	}

}
