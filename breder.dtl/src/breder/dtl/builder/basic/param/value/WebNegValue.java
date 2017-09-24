package breder.dtl.builder.basic.param.value;

import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebNegValue extends WebUnaryValue {

	public static Object toString(DyanmicTagLanguageContext context, Object left) {
		if (left instanceof Double) {
			return -((Double) left);
		} else {
			throw new IllegalArgumentException("neg operation is not implemented");
		}
	}

}
