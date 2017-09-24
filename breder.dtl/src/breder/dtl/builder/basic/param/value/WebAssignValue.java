package breder.dtl.builder.basic.param.value;

import breder.dtl.builder.AbstractTag;
import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebAssignValue extends AbstractTag {

	public static String toString(DyanmicTagLanguageContext context, String key, Object value) {
		context.setAttribute(key, value);
		return "";
	}

}
