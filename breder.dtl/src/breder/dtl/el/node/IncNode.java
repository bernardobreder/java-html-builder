package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public class IncNode extends UnaryNode {

	public IncNode(Token token, Node left) {
		super(token, left);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.getToken().image + "++";
	}

}
