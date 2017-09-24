package breder.dtl.builder.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import breder.dtl.builder.DynamicTagLanguage;
import breder.dtl.builder.basic.param.value.WebAssignValue;
import breder.dtl.builder.basic.param.value.WebBooleanValue;
import breder.dtl.builder.basic.param.value.WebDecValue;
import breder.dtl.builder.basic.param.value.WebDefineValue;
import breder.dtl.builder.basic.param.value.WebDivValue;
import breder.dtl.builder.basic.param.value.WebEqualValue;
import breder.dtl.builder.basic.param.value.WebGetVariable;
import breder.dtl.builder.basic.param.value.WebGreaterEqualValue;
import breder.dtl.builder.basic.param.value.WebGreaterValue;
import breder.dtl.builder.basic.param.value.WebIncValue;
import breder.dtl.builder.basic.param.value.WebLowerEqualValue;
import breder.dtl.builder.basic.param.value.WebLowerValue;
import breder.dtl.builder.basic.param.value.WebMulValue;
import breder.dtl.builder.basic.param.value.WebNegValue;
import breder.dtl.builder.basic.param.value.WebNotEqualValue;
import breder.dtl.builder.basic.param.value.WebNotValue;
import breder.dtl.builder.basic.param.value.WebNumberValue;
import breder.dtl.builder.basic.param.value.WebStringValue;
import breder.dtl.builder.basic.param.value.WebSubValue;
import breder.dtl.builder.basic.param.value.WebSumValue;
import breder.dtl.el.node.AssignNode;
import breder.dtl.el.node.BooleanNode;
import breder.dtl.el.node.DecNode;
import breder.dtl.el.node.DefineNode;
import breder.dtl.el.node.DivNode;
import breder.dtl.el.node.EqualNode;
import breder.dtl.el.node.GreaterEqualNode;
import breder.dtl.el.node.GreaterNode;
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

public class BasicDynamicTagLanguage extends DynamicTagLanguage {

	public BasicDynamicTagLanguage(String resource) {
		super(resource);
	}

	public BasicDynamicTagLanguage(File file) throws FileNotFoundException {
		super(file);
	}

	public BasicDynamicTagLanguage(InputStream input) {
		super(input);
	}

	{
		this.addNode(TagNode.class, WebGetVariable.class);
		this.addNode(NumberNode.class, WebNumberValue.class);
		this.addNode(StringNode.class, WebStringValue.class);
		this.addNode(BooleanNode.class, WebBooleanValue.class);
		this.addNode(EqualNode.class, WebEqualValue.class);
		this.addNode(NotEqualNode.class, WebNotEqualValue.class);
		this.addNode(GreaterNode.class, WebGreaterValue.class);
		this.addNode(LowerNode.class, WebLowerValue.class);
		this.addNode(GreaterEqualNode.class, WebGreaterEqualValue.class);
		this.addNode(LowerEqualNode.class, WebLowerEqualValue.class);
		this.addNode(SumNode.class, WebSumValue.class);
		this.addNode(SubNode.class, WebSubValue.class);
		this.addNode(MulNode.class, WebMulValue.class);
		this.addNode(DivNode.class, WebDivValue.class);
		this.addNode(AssignNode.class, WebAssignValue.class);
		this.addNode(DefineNode.class, WebDefineValue.class);
		this.addNode(DecNode.class, WebDecValue.class);
		this.addNode(IncNode.class, WebIncValue.class);
		this.addNode(NegNode.class, WebNegValue.class);
		this.addNode(NotNode.class, WebNotValue.class);
	}

}
