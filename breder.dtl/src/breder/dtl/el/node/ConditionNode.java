package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public abstract class ConditionNode extends BinaryNode {

	/**
	 * Condição
	 * 
	 * @param token
	 * @param left
	 * @param right
	 */
	public ConditionNode(Token token, Node left, Node right) {
		super(token, left, right);
	}

}
