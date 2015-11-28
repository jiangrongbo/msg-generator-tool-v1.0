package com.csii.pe.tool.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class FileUtils {
	private static Log log = LogFactory.getLog(FileUtils.class);

	public static void storeMsgFile(String filePath, String content) {
		File msgFile = new File(filePath);
		try {
			FileWriter msgWriter = new FileWriter(msgFile);
			msgWriter.write(content);
			if (msgWriter != null) {
				msgWriter.close();
				msgWriter = null;
			}
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
}
