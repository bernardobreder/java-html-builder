package breder.dtl.web.tag.basic;

public abstract class WebText extends HtmlTag {

	private String value;

	/**
	 * Retorna
	 * 
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 * @return owner
	 */
	public WebText setValue(String value) {
		this.value = value;
		return this;
	}

}
