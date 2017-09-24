package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public class BooleanNode extends PrimitiveNode {

	public BooleanNode(Token token) {
		super(token);
	}

	public Boolean getFlag() {
		if (this.getToken().image.equals("true")) {
			return true;
		} else {
			return false;
		}
	}

}
