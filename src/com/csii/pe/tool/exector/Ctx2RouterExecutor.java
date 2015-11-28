package com.csii.pe.tool.exector;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csii.pe.tool.util.FileUtils;
import com.csii.pe.tool.util.StringUtils;

public class Ctx2RouterExecutor extends AbstractExecutor {
	private Log log = LogFactory.getLog(this.getClass());

	public Ctx2RouterExecutor(String filePath, String fileName,
			String msgField, String msgFieldType, String msgFieldComment) {
		super(filePath, fileName, msgField, msgFieldType, msgFieldComment);
		// implements by subclass to generate message file.
		execute();
	}

	@Override
	public void execute() {
		log.info("generate context=>router message file begin.");
		log.info("abslute file path:\n" + this.getFilePath() + "\\"
				+ this.getFileName());
		log.info("message field:\n" + this.getMsgField());
		log.info("message field type:\n" + this.getMsgFieldType());
		log.info("message field comment:\n" + this.getMsgFieldComment());
		String fullPath = this.getFilePath() + "\\" + this.getFileName();
		String msgField = this.getMsgField();
		String msgFieldComment = this.getMsgFieldComment();

		String[] msgFields = msgField.split("\n");
		String[] msgFieldTypes = msgField.split("\n");
		String[] msgFieldComments = msgFieldComment.split("\n");

		if (msgFields.length != msgFieldTypes.length) {
			throw new IllegalArgumentException(
					"the count of message field,type not equal.");
		}

		StringBuilder strBuffer = new StringBuilder();
		strBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		strBuffer.append("<!DOCTYPE segment SYSTEM \"packet.dtd\">\n");
		strBuffer.append("<segment>\n");
		for (int i = 0; i < msgFields.length; i++) {
			String field = msgFields[i];
			String fieldComment = msgFieldComments[i];
			strBuffer.append("\t<xmlTag><String name=\"");
			strBuffer.append(StringUtils.format2Context(field));
			strBuffer.append("\"></String></xmlTag>");
			if (msgFieldComment != null && !"".equals(msgFieldComment)) {
				strBuffer.append("<!--");
				strBuffer.append(fieldComment);
				strBuffer.append("-->");
			}
			strBuffer.append("\n");
		}
		strBuffer.append("</segment>\n");
		log.info("message content:\n" + strBuffer);// output msgContent to log.
		FileUtils.storeMsgFile(fullPath, strBuffer.toString());

	}
}
