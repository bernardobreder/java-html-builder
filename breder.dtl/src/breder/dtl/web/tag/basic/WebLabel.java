package breder.dtl.web.tag.basic;

import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebLabel extends HtmlTag {

	public static String toString(DyanmicTagLanguageContext context, String... strings) {
		return "<span>" + toString(strings) + "</span>";
	}

}
