package com.csii.pe.tool.exector;

public abstract class AbstractExecutor implements Executable {
	private String fileName;
	private String filePath;
	private String msgField;
	private String msgFieldType;
	private String msgFieldComment;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getMsgField() {
		return msgField;
	}

	public void setMsgField(String msgField) {
		this.msgField = msgField;
	}

	public String getMsgFieldType() {
		return msgFieldType;
	}

	public void setMsgFieldType(String msgFieldType) {
		this.msgFieldType = msgFieldType;
	}

	public String getMsgFieldComment() {
		return msgFieldComment;
	}

	public void setMsgFieldComment(String msgFieldComment) {
		this.msgFieldComment = msgFieldComment;
	}

	public AbstractExecutor(String filePath , String fileName, String msgField,
			String msgFieldType, String msgFieldComment) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;
		this.msgField = msgField;
		this.msgFieldType = msgFieldType;
		this.msgFieldComment = msgFieldComment;
	} 
	 
}
