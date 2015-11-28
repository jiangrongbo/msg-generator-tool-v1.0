package com.csii.pe.tool.util;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testFormat2Context() {
		String str = StringUtils.format2Context("TEXT_FIELD");
		System.out.println(str);
	}

	@Test
	public void testGetTypeLength() {
		String strLen = StringUtils.getTypeLength("STRING(20,20)");
		System.out.println(strLen);

		String intLen = StringUtils.getTypeLength("INT(10)");
		System.out.println(intLen);
	}
	
	@Test
	public void testGetType()
	{
		String strType = StringUtils.getType("STRING(20)");
		System.out.println(strType);
	}
}
