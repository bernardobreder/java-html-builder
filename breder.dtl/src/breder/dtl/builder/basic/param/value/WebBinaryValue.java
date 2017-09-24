package breder.dtl.builder.basic.param.value;

import breder.dtl.builder.AbstractTag;

public abstract class WebBinaryValue extends WebUnaryValue {

	private AbstractTag right;

	/**
	 * Retorna
	 * 
	 * @return right
	 */
	public AbstractTag getRight() {
		return right;
	}

	/**
	 * @param right
	 * @return owner
	 */
	public WebBinaryValue setRight(AbstractTag right) {
		this.right = right;
		return this;
	}

}
