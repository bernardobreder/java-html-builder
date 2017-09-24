package breder.dtl.builder.basic.param.value;

import breder.dtl.builder.DyanmicTagLanguageContext;

public class WebSumValue extends WebArithmeticValue {

	public static Object toString(DyanmicTagLanguageContext context, Object left, Object right) {
		if (right == null) {
			right = "(null)";
		}
		if (left == null) {
			left = "(null)";
		}
		if (left instanceof Double) {
			return ((Double) left) + ((Double) right);
		} else if (left instanceof String) {
			String rightStr = right.toString();
			if (right instanceof Double) {
				double value = (Double) right;
				if (value == (int) value) {
					rightStr = Integer.valueOf((int) value).toString();
				}
			}
			return ((String) left) + rightStr;
		} else if (left instanceof Boolean) {
			return ((Boolean) left) || ((Boolean) right);
		} else {
			throw new IllegalArgumentException("sum operation is not implemented");
		}
	}

}
