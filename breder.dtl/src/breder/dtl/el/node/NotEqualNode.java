package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public class NotEqualNode extends ConditionNode {

	public NotEqualNode(Token token, Node left, Node right) {
		super(token, left, right);
	}

}
