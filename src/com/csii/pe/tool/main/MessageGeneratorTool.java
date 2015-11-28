package com.csii.pe.tool.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csii.pe.tool.ui.MainFrame;

public class MessageGeneratorTool {
	private static Log log = LogFactory.getLog(MessageGeneratorTool.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.showWindow();
		log.info("Power Engine esb message file generator tool start sucessfully.");
	}

}
