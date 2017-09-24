package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public class NumberNode extends PrimitiveNode {

	public NumberNode(Token token) {
		super(token);
	}

	public Double getDouble() {
		return new Double(this.getToken().image);
	}

	public Integer getInteger() {
		return new Integer(this.getToken().image);
	}

}
