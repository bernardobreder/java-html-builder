package breder.dtl.builder.basic.param.value;

import breder.dtl.builder.DyanmicTagLanguageContext;
import breder.dtl.web.tag.basic.WebPrimitiveValue;

public class WebStringValue extends WebPrimitiveValue {

	public static Object toString(DyanmicTagLanguageContext context, String value) {
		return value;
	}

}
