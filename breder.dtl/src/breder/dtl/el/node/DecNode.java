package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public class DecNode extends UnaryNode {

	public DecNode(Token token, Node left) {
		super(token, left);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.getToken().image + "--";
	}

}
