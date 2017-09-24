package breder.dtl.builder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Contexto de uma página
 * 
 * 
 * @author Bernardo Breder
 */
public class DyanmicTagLanguageContext {

	/**
	 * Parametros da requisição
	 */
	private Map<String, String> params;

	/**
	 * Parametros da requisição
	 */
	private Map<String, Stack<Object>> attributes = new HashMap<String, Stack<Object>>();

	private final ByteArrayOutputStream output = new ByteArrayOutputStream();

	/**
	 * Construtor padrão
	 */
	public DyanmicTagLanguageContext() {
		this(new HashMap<String, String>());
	}

	/**
	 * Construtor padrão
	 * 
	 * @param params
	 */
	public DyanmicTagLanguageContext(Map<String, String> params) {
		super();
		this.params = params;
	}

	public Map<String, String> getParams() {
		return this.params;
	}

	public List<? extends Object> getAttributeAsList(String name) {
		return (List<? extends Object>) this.getAttribute(name);
	}

	public Double getAttributeAsNumber(String name) {
		return (Double) this.getAttribute(name);
	}

	public Boolean getAttributeAsBoolean(String name) {
		return (Boolean) this.getAttribute(name);
	}

	public String getAttributeAsString(String name) {
		return (String) this.getAttribute(name);
	}

	public Object getAttribute(String name) {
		Stack<Object> stack = this.attributes.get(name);
		if (stack != null) {
			return stack.peek();
		} else {
			return null;
		}
	}

	public void setAttribute(String name, Object value) {
		Stack<Object> stack = this.attributes.get(name);
		if (stack == null) {
			stack = new Stack<Object>();
			stack.push(null);
			this.attributes.put(name, stack);
		}
		stack.set(stack.size() - 1, value);
	}

	public void defineAttribute(String name, Object value) {
		Stack<Object> stack = this.attributes.get(name);
		if (stack == null) {
			stack = new Stack<Object>();
			this.attributes.put(name, stack);
		}
		stack.push(value);
	}

	public void removeAttribute(String name) {
		Stack<Object> stack = this.attributes.get(name);
		if (stack != null) {
			stack.pop();
			if (stack.isEmpty()) {
				this.attributes.remove(name);
			}
		}
	}

	// public void incAttributeAsNumber(String name) {
	// Double value = this.getAttributeAsInteger(name);
	// if (value != null) {
	// this.setAttribute(name, value + 1);
	// }
	// }
	//
	// public void decAttributeAsNumber(String name) {
	// Double value = this.getAttributeAsInteger(name);
	// if (value != null) {
	// this.setAttribute(name, value - 1);
	// }
	// }

	public Double checkAttributeAsInteger(String name) {
		Double value = this.getAttributeAsNumber(name);
		if (value == null) {
			throw new IllegalArgumentException(name);
		}
		return value;
	}

	public String checkAttributeAsString(String name) {
		String value = this.getAttributeAsString(name);
		if (value == null) {
			throw new IllegalArgumentException(name);
		}
		return value;
	}

	public Boolean checkAttributeAsBoolean(String name) {
		Boolean value = this.getAttributeAsBoolean(name);
		if (value == null) {
			throw new IllegalArgumentException(name);
		}
		return value;
	}

	public Object checkAttribute(String name) {
		Object value = this.getAttribute(name);
		if (value == null) {
			throw new IllegalArgumentException(name);
		}
		return value;
	}

	/**
	 * @param arg0
	 * @throws IOException
	 * @see java.io.OutputStream#write(byte[])
	 */
	public void write(byte[] arg0) throws IOException {
		output.write(arg0);
	}

	/**
	 * @return
	 * @see java.io.ByteArrayOutputStream#toByteArray()
	 */
	public byte[] toByteArray() {
		return output.toByteArray();
	}

}
