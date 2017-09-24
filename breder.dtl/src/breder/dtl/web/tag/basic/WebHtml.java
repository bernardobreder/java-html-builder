package breder.dtl.web.tag.basic;

import breder.dtl.builder.AbstractTag;
import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebHtml extends AbstractTag {

	public static String toString(DyanmicTagLanguageContext context, String... strings) {
		return "<html>" + toString(strings) + "</html>";
	}

}
