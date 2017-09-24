package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public class LowerEqualNode extends ConditionNode {

	public LowerEqualNode(Token token, Node left, Node right) {
		super(token, left, right);
	}

}
