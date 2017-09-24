package breder.dtl.web.tag.basic;

import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebTextField extends HtmlTag {

	public static String toString(DyanmicTagLanguageContext context, String id, String... strings) {
		StringBuilder sb = new StringBuilder("<input ");
		if (id != null) {
			sb.append("id='" + id + "' ");
		}
		sb.append("/>");
		return sb.toString();
	}

}
