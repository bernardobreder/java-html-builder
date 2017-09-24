package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public class NotNode extends UnaryNode {

	public NotNode(Token token, Node left) {
		super(token, left);
	}

}
