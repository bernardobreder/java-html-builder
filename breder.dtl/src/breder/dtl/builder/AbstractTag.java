package breder.dtl.builder;

/**
 * Classe que representa uma tag generica
 * 
 * 
 * @author Bernardo Breder
 */
public abstract class AbstractTag {

	/**
	 * Concatena as Strings
	 * 
	 * @param strings
	 * @return string concatenada
	 */
	public static String toString(String... strings) {
		int length = strings.length;
		if (length == 0) {
			return "";
		} else if (length == 1) {
			return strings[0];
		}
		StringBuilder sb = new StringBuilder();
		for (String string : strings) {
			sb.append(string);
		}
		return sb.toString();
	}

}
