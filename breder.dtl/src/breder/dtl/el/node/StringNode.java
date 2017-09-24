package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public class StringNode extends PrimitiveNode {

	private String content;

	public StringNode(Token token) {
		super(token);
	}

	public String getContent() {
		if (this.content == null) {
			this.content = this.getToken().image.substring(1, this.getToken().image.length() - 1);
		}
		return this.content;
	}

}
