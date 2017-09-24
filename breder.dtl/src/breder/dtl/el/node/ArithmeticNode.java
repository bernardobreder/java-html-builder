package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public abstract class ArithmeticNode extends BinaryNode {

	public ArithmeticNode(Token token, Node left, Node right) {
		super(token, left, right);
	}

}
