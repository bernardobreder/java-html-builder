package breder.dtl.el.factory;

import breder.dtl.el.node.AssignNode;
import breder.dtl.el.node.BooleanNode;
import breder.dtl.el.node.DecNode;
import breder.dtl.el.node.DefineNode;
import breder.dtl.el.node.DivNode;
import breder.dtl.el.node.EqualNode;
import breder.dtl.el.node.GreaterEqualNode;
import breder.dtl.el.node.GreaterNode;
import breder.dtl.el.node.IdentifyNode;
import breder.dtl.el.node.IncNode;
import breder.dtl.el.node.LowerEqualNode;
import breder.dtl.el.node.LowerNode;
import breder.dtl.el.node.MulNode;
import breder.dtl.el.node.NegNode;
import breder.dtl.el.node.NotEqualNode;
import breder.dtl.el.node.NotNode;
import breder.dtl.el.node.NumberNode;
import breder.dtl.el.node.StringNode;
import breder.dtl.el.node.SubNode;
import breder.dtl.el.node.SumNode;
import breder.dtl.el.node.TagNode;

public interface INodeFactory {

	public <E extends EqualNode> E build(E node);

	public <E extends NotEqualNode> E build(E node);

	public <E extends LowerNode> E build(E node);

	public <E extends LowerEqualNode> E build(E node);

	public <E extends GreaterNode> E build(E node);

	public <E extends GreaterEqualNode> E build(E node);

	public <E extends SumNode> E build(E node);

	public <E extends SubNode> E build(E node);

	public <E extends MulNode> E build(E node);

	public <E extends DivNode> E build(E node);

	public <E extends StringNode> E build(E node);

	public <E extends NumberNode> E build(E node);

	public <E extends BooleanNode> E build(E node);

	public <E extends IncNode> E build(E node);

	public <E extends DecNode> E build(E node);

	public <E extends NotNode> E build(E node);

	public <E extends NegNode> E build(E node);

	public <E extends IdentifyNode> E build(E node);

	public <E extends TagNode> E build(E node);

	public <E extends AssignNode> E build(E node);

	public <E extends DefineNode> E build(E node);

}
