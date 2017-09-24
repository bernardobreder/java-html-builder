package breder.dtl.builder.basic.param.value;

import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebDefineValue extends WebAssignValue {

	public static String toString(DyanmicTagLanguageContext context, String key, Object value) {
		context.defineAttribute(key, value);
		return "";
	}

}
