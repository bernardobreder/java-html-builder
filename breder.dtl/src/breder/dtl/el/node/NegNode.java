package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public class NegNode extends UnaryNode {

	public NegNode(Token token, Node left) {
		super(token, left);
	}

}
