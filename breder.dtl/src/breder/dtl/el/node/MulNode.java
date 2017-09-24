package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public class MulNode extends ArithmeticNode {

	public MulNode(Token token, Node left, Node right) {
		super(token, left, right);
	}

}
