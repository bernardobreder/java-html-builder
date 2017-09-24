package breder.dtl.web.tag.control;

import breder.dtl.builder.AbstractTag;
import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebIf extends AbstractTag {

	public static String toString(DyanmicTagLanguageContext context, Object condition, String... strings) {
		if (condition.equals(true)) {
			return toString(strings);
		}
		return "";
	}

}
