package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

/**
 * Comparação
 * 
 * 
 * @author Bernardo Breder
 */
public class EqualNode extends ConditionNode {

	/**
	 * Construtor
	 * 
	 * @param token
	 * @param left
	 * @param right
	 */
	public EqualNode(Token token, Node left, Node right) {
		super(token, left, right);
	}

}
