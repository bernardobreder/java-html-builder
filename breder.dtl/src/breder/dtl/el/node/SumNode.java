package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public class SumNode extends ArithmeticNode {

	public SumNode(Token token, Node left, Node right) {
		super(token, left, right);
	}

}
