package breder.dtl.builder.basic.param.value;

import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebLowerValue extends WebConditionValue {

	public static Object toString(DyanmicTagLanguageContext context, Object left, Object right) {
		if (left instanceof Double) {
			return Boolean.valueOf(((Double) left).compareTo((Double) right) < 0);
		} else if (left instanceof String) {
			return Boolean.valueOf(((String) left).compareTo((String) right) < 0);
		} else if (left instanceof Boolean) {
			return Boolean.valueOf(((Boolean) left).compareTo((Boolean) right) < 0);
		} else {
			return false;
		}
	}

}
