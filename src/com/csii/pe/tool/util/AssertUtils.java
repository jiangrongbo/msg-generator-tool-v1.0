package com.csii.pe.tool.util;

import javax.swing.JOptionPane;

public class AssertUtils {
	private static PropUtils props = new PropUtils();

	public static boolean isEmptyAssert(String field, String tipsInfo) {
		if (null == field || "".equals(field)) {
			JOptionPane.showMessageDialog(null, tipsInfo,
					getText("msgbox.alert.error.tips"),
					JOptionPane.ERROR_MESSAGE);
			return true;
		}
		return false;
	}

	public static String getText(String key) {
		return props.getText(key);
	}
}
