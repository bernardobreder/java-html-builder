package breder.dtl.web.tag.basic;

import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebTable extends HtmlTag {

	public static String toString(DyanmicTagLanguageContext context, String... strings) {
		return "<table cellpadding='0' cellspacing='0'>" + toString(strings) + "</table>";
	}

}
