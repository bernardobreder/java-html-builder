package breder.dtl.builder.basic.param.value;

import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebSubValue extends WebArithmeticValue {

	public static Object toString(DyanmicTagLanguageContext context, Object left, Object right) {
		if (left instanceof Double) {
			return ((Double) left) - ((Double) right);
		} else {
			throw new IllegalArgumentException("sub operation is not implemented");
		}
	}

}
