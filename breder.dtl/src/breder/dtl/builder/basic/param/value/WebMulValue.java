package breder.dtl.builder.basic.param.value;

import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebMulValue extends WebArithmeticValue {

	public static Object toString(DyanmicTagLanguageContext context, Object left, Object right) {
		if (left instanceof Double) {
			return ((Double) left) * ((Double) right);
		} else if (left instanceof Boolean) {
			return ((Boolean) left) && ((Boolean) right);
		} else {
			throw new IllegalArgumentException("multiply operation is not implemented");
		}
	}

}
