package breder.dtl.el.util;

import breder.dtl.el.parse.Token;

public class TokenUtil {

	public static Token join(Token left, Token right) {
		Token token = new Token();
		token.beginLine = left.beginLine;
		token.endLine = right.endLine;
		token.beginColumn = left.beginColumn;
		token.endColumn = right.endColumn;
		token.image = left.image + right.image;
		token.kind = left.kind;
		token.next = right.next;
		token.specialToken = right.specialToken;
		return token;
	}

}
