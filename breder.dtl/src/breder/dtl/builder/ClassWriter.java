package breder.dtl.builder;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Classe responsável por criar uma classe dinamicamente
 * 
 * 
 * @author Bernardo Breder
 */
public class ClassWriter {

	/**
	 * Saida
	 */
	private final PrintWriter writer;

	/**
	 * Tabulação
	 */
	private int tab;

	private String classname;

	/**
	 * construtor padrão
	 * 
	 * @param output
	 */
	public ClassWriter(OutputStream output) {
		this.writer = new PrintWriter(output);
	}

	/**
	 * Imprime o pacote da classe
	 * 
	 * @param name
	 * @return owner
	 */
	public ClassWriter printPackage(String name) {
		this.println("package " + name + ";");
		this.println();
		return this;
	}

	public ClassWriter printClass(String name, String[] extendArray, String[] implementArray) {
		this.print("");
		this.classname = name;
		this.writer.print("public class " + name);
		if (extendArray != null) {
			this.writer.print(" extends ");
			int length = extendArray.length;
			for (int n = 0; n < length; n++) {
				String extend = extendArray[n];
				this.print(extend);
				if (n != length - 1) {
					this.writer.print(", ");
				}
			}
		}
		if (implementArray != null) {
			this.writer.print(" implement ");
			int length = implementArray.length;
			for (int n = 0; n < length; n++) {
				String implement = implementArray[n];
				this.print(implement);
				if (n != length - 1) {
					this.writer.print(", ");
				}
			}
		}
		this.writer.println(" {");
		this.println();
		this.incTab();
		return this;
	}

	public ClassWriter printMethod(String name, String returnClass, String[] paramsArray) {
		return this.printMethod(name, returnClass, paramsArray, false);
	}

	public ClassWriter printMethod(String name, String returnClass, String[] paramsArray, boolean isStatic) {
		this.print("");
		this.writer.print("public");
		if (isStatic) {
			this.writer.print(" static");
		}
		if (returnClass == null) {
			this.writer.print(" void");
		} else {
			this.writer.print(" " + returnClass);
		}
		this.writer.print(" " + name + " (");
		if (paramsArray != null) {
			int length = paramsArray.length;
			for (int n = 0; n < length; n++) {
				String param = paramsArray[n];
				this.writer.print(param);
				if (n != length - 1) {
					this.writer.print(", ");
				}
			}
		}
		this.writer.println(") {");
		this.incTab();
		return this;
	}

	public ClassWriter printConstrutor(String[] paramsArray) {
		this.print("public");
		this.writer.print(" " + this.classname + " (");
		if (paramsArray != null) {
			int length = paramsArray.length;
			for (int n = 0; n < length; n++) {
				String param = paramsArray[n];
				this.writer.print(param);
				if (n != length - 1) {
					this.writer.print(", ");
				}
			}
		}
		this.writer.println(") {");
		this.incTab();
		return this;
	}

	public ClassWriter printClose() {
		this.decTab();
		this.println("}");
		this.println();
		return this;
	}

	public void printCode(String code, Object... objects) {
		this.println(code + ";", objects);
	}

	/**
	 * Pula de linha
	 * 
	 * @return proprio
	 */
	public ClassWriter println() {
		return this.println("");
	}

	/**
	 * Imprime um texto
	 * 
	 * @param text
	 * @param objects
	 * @return texto
	 */
	public ClassWriter println(String text, Object... objects) {
		return this.print(text + "\n", objects);
	}

	/**
	 * Imprime um texto
	 * 
	 * @param text
	 * @param objects
	 * @return texto
	 */
	public ClassWriter print(String text, Object... objects) {
		for (int n = 0; n < tab; n++) {
			this.writer.print('\t');
		}
		if (objects.length > 0) {
			this.writer.print(String.format(text, objects));
		} else {
			this.writer.print(text);
		}
		return this;
	}

	/**
	 * Incrementa uma tabulação
	 * 
	 * @return proprio
	 */
	public ClassWriter incTab() {
		this.tab++;
		return this;
	}

	/**
	 * Decrementa uma tabulação
	 * 
	 * @return proprio
	 */
	public ClassWriter decTab() {
		this.tab--;
		return this;
	}

	/**
	 * Incrementa uma linha
	 * 
	 * @return proprio
	 */
	public ClassWriter incLine() {
		this.println("");
		return this;
	}

	/**
	 * Fecha a stream
	 */
	public void close() {
		this.writer.close();
	}

}
