package com.csii.pe.tool.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class StringUtils {
	/**
	 * convert string to context format,eg. TEXT_FIELD=>TextField.
	 * 
	 * @param field
	 *            ,string style like TEXT_FIELD.
	 * @return the formated string like "TextField" style
	 * @author tzbank
	 */
	public static String format2Context(String field) {
		if (field == null || "".equals(field)) {
			throw new IllegalArgumentException("field must't be empty!");
		}
		String[] fieldParts = field.split("_");
		StringBuilder strBuffer = new StringBuilder();
		for (int i = 0; i < fieldParts.length; i++) {
			String fieldPart = fieldParts[i];
			fieldPart = fieldPart.toLowerCase();

			strBuffer.append(Character.toUpperCase(fieldPart.charAt(0)));
			if (fieldPart.length() >= 2) {
				strBuffer.append(fieldPart.substring(1));
			}
		}
		return strBuffer.toString();
	}

	/**
	 * get type length from type string.
	 * 
	 * @param type
	 *            format like STRING(20),INT(10)...
	 * @return the length of type
	 * @author tzbank
	 */
	public static String getTypeLength(String type) {
		checkType(type);
		int startIndex = type.lastIndexOf('(');
		int endIndex = type.lastIndexOf(')');
		String strLen = type.substring(startIndex + 1, endIndex);
		return strLen;
	}

	public static String getType(String type) {
		int endIndex = type.lastIndexOf("(");
		return type.substring(0, endIndex);
	}

	/**
	 * check the type string format.
	 * 
	 * @param type
	 */
	private static void checkType(String type) {
		Pattern typePattern = Pattern
				.compile("^[a-zA-Z0-9]+\\([0-9]+(.[0-9]+)*\\)$");
		Matcher matcher = typePattern.matcher(type);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(
					"the format type string is error,the conrect style like STRING(20)");
		}
	}
}
