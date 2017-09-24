package breder.dtl.builder.basic.param.value;

import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebDecValue extends WebUnaryValue {

	public static Object toString(DyanmicTagLanguageContext context, String left) {
		Object value = context.getAttribute(left);
		if (value instanceof Double) {
			context.setAttribute(left, ((Double) value) - 1);
			return value;
		} else {
			throw new IllegalArgumentException("inc operation is not implemented");
		}
	}

}
