package breder.dtl.builder.factory;

import breder.dtl.builder.DyanmicTagLanguageContext;
import breder.dtl.el.node.EqualNode;
import breder.dtl.el.node.Node;
import breder.dtl.el.parse.Token;

public class HtmlEqualNode extends EqualNode implements HtmlNode {

	public HtmlEqualNode(Token token, Node left, Node right) {
		super(token, left, right);
	}

	@Override
	public String toTagString(DyanmicTagLanguageContext context) {
		return null;
	}

	@Override
	public String toExpString(DyanmicTagLanguageContext context) {
		return null;
	}

}
