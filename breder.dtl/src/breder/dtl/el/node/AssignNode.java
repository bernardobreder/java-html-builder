package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

/**
 * Nó de associação
 * 
 * 
 * @author Bernardo Breder
 */
public class AssignNode extends BinaryNode {

	/**
	 * Construtor padrão
	 * 
	 * @param token
	 * @param left
	 * @param right
	 */
	public AssignNode(Token token, Node left, Node right) {
		super(token, left, right);
	}

}
