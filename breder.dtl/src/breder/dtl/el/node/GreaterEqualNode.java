package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public class GreaterEqualNode extends ConditionNode {

	public GreaterEqualNode(Token token, Node left, Node right) {
		super(token, left, right);
	}

}
