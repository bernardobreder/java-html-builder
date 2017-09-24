package breder.dtl.builder;

import breder.dtl.el.parse.Token;

public class SemanticParserException extends Exception {

	public SemanticParserException(Token token) {
		super("invalied token '" + token.image + "' at line " + token.beginLine + " and column " + token.beginColumn);
	}

}
