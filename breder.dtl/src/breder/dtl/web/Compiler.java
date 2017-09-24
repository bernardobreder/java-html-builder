package breder.dtl.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import breder.dtl.web.tag.MyHtmlDynamicTagLanguage;

public class Compiler {

	public static void main(String[] args) throws Exception {
		InputStream input = Compiler.class.getClassLoader().getResourceAsStream("test/web/html.dtl");
		MyHtmlDynamicTagLanguage dtl = new MyHtmlDynamicTagLanguage(input);
		dtl.setOutputStream(new FileOutputStream(new File("work", "MyPage.java")));
		dtl.execute();
	}

}
