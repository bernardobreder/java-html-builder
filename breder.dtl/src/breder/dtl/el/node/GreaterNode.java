package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public class GreaterNode extends ConditionNode {

	public GreaterNode(Token token, Node left, Node right) {
		super(token, left, right);
	}

}
