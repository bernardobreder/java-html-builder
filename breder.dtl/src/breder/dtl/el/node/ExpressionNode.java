package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

/**
 * Estrutura mais basica de uma expressão
 * 
 * 
 * @author bbreder
 */
public class ExpressionNode extends Node {

	/**
	 * Construtor
	 * 
	 * @param token
	 */
	public ExpressionNode(Token token) {
		super(token);
	}

}
