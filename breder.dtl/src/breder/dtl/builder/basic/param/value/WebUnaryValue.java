package breder.dtl.builder.basic.param.value;

import breder.dtl.builder.AbstractTag;

public abstract class WebUnaryValue extends AbstractTag {

	private AbstractTag left;

	/**
	 * Retorna
	 * 
	 * @return left
	 */
	public AbstractTag getLeft() {
		return left;
	}

	/**
	 * @param left
	 * @return owner
	 */
	public WebUnaryValue setLeft(AbstractTag left) {
		this.left = left;
		return this;
	}

}
