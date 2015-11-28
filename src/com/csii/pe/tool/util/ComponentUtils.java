package com.csii.pe.tool.util;

import javax.swing.JComponent;

public class ComponentUtils {
	
	/**
	 * JComponentUtils used to set component properties convenient. 
	 * @param component
	 * @param width
	 * @param height
	 * @param x
	 * @param y
	 * @param visible
	 * @author tzbank
	 */
	public void setProps(JComponent component,int width,int height,int x,int y,boolean visible)
	{
		component.setSize(width,height);
		component.setLocation(x,y);
		component.setVisible(true);
	}
}
