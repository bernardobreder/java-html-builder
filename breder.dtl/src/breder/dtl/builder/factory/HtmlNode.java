package breder.dtl.builder.factory;

import breder.dtl.builder.DyanmicTagLanguageContext;

public interface HtmlNode {

	public String toTagString(DyanmicTagLanguageContext context);

	public String toExpString(DyanmicTagLanguageContext context);

}
