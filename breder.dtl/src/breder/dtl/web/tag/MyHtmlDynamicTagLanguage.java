package breder.dtl.web.tag;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import breder.dtl.builder.basic.BasicDynamicTagLanguage;
import breder.dtl.web.tag.basic.WebBody;
import breder.dtl.web.tag.basic.WebColumn;
import breder.dtl.web.tag.basic.WebHtml;
import breder.dtl.web.tag.basic.WebLabel;
import breder.dtl.web.tag.basic.WebParagraph;
import breder.dtl.web.tag.basic.WebRow;
import breder.dtl.web.tag.basic.WebTable;
import breder.dtl.web.tag.basic.WebTextField;
import breder.dtl.web.tag.control.WebIf;

public class MyHtmlDynamicTagLanguage extends BasicDynamicTagLanguage {

	{
		{
			this.addTag("html", WebHtml.class);
			this.addTag("body", WebBody.class);
			this.addTag("table", WebTable.class);
			this.addTag("row", WebRow.class);
			this.addTag("col", WebColumn.class);
			this.addTag("p", WebParagraph.class);
			this.addTag("label", WebLabel.class);
		}
		{
			this.addTag("textfield", WebTextField.class).addParams("id");
		}
		{
			this.addTag("if", WebIf.class);
			// this.addTag("for", WebFor.class);
			// this.addTag("foreach", WebForEach.class);
			// this.addTag("while", WebWhile.class);
			// this.addTag("repeat", WebRepeat.class);
		}
	}

	public MyHtmlDynamicTagLanguage(File file) throws FileNotFoundException {
		super(file);
	}

	public MyHtmlDynamicTagLanguage(String resource) {
		super(resource);
	}

	public MyHtmlDynamicTagLanguage(InputStream input) {
		super(input);
	}

}
