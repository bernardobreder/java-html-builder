package breder.dtl.builder.basic.param.value;

import breder.dtl.builder.AbstractTag;
import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebGetVariable extends AbstractTag {

	public static Object toString(DyanmicTagLanguageContext context, String key) {
		return context.getAttribute(key);
	}

}
