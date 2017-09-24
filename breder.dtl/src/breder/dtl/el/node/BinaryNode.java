package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

/**
 * Nó binário
 * 
 * 
 * @author Bernardo Breder
 */
public abstract class BinaryNode extends UnaryNode {

	/** Valor a direita */
	private Node right;

	/**
	 * Construtor padrão
	 * 
	 * @param token
	 * @param left
	 * @param right
	 */
	public BinaryNode(Token token, Node left, Node right) {
		super(token, left);
		this.right = right;
	}

	/**
	 * Retorna
	 * 
	 * @return right
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * @param right
	 * @return owner
	 */
	public BinaryNode setRight(Node right) {
		this.right = right;
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.getLeft().toString() + ' ' + this.getToken().image + ' ' + this.getRight();
	}

}
