package breder.dtl.builder.basic.param.value;

import breder.dtl.builder.DyanmicTagLanguageContext;
import breder.dtl.web.tag.basic.WebPrimitiveValue;

public class WebBooleanValue extends WebPrimitiveValue {

	public static Object toString(DyanmicTagLanguageContext context, Boolean value) {
		return value;
	}

}
