package com.csii.pe.tool.util;

public class PropUtilsTest {
	public static void main(String[] args) {
		PropUtils util = new PropUtils();
		String info = util.getText("label.text.inputmsg.info");
		System.out.println(info);
		
	}
}
