package breder.dtl.el.node;

import breder.dtl.el.parse.Token;

public class DefineNode extends AssignNode {

	private Node type;

	public DefineNode(Token token, Node type, Node variable, Node value) {
		super(token, variable, value);
		this.type = type;
	}

	/**
	 * Retorna
	 * 
	 * @return type
	 */
	public Node getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(Node type) {
		this.type = type;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.getType().toString() + ' ' + super.toString();
	}

}
