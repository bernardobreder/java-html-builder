package breder.dtl.builder.basic.param.value;

import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebNotEqualValue extends WebConditionValue {

	public static Object toString(DyanmicTagLanguageContext context, Object left, Object right) {
		return !left.equals(right);
	}

}
