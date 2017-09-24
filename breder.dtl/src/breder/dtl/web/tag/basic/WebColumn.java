package breder.dtl.web.tag.basic;

import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebColumn extends HtmlTag {

	public static String toString(DyanmicTagLanguageContext context, String... strings) {
		return "<td>" + toString(strings) + "</td>";
	}

}
