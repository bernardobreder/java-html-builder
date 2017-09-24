package breder.dtl.web.tag.basic;

import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebRow extends HtmlTag {

	public static String toString(DyanmicTagLanguageContext context, String... strings) {
		return "<tr>" + toString(strings) + "</tr>";
	}

}
