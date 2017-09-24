package breder.dtl.builder.basic.param.value;

import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebNotValue extends WebUnaryValue {

	public static Object toString(DyanmicTagLanguageContext context, Object left) {
		if (left instanceof Boolean) {
			return !((Boolean) left);
		} else {
			throw new IllegalArgumentException("not operation is not implemented");
		}
	}

}
