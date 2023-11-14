package com.paychex.pcdcmsgproc.boxCollaborationEvent.model;

public class BoxCollaborationEventInfo {
	
	private int eventId;
	private String eventType;
	private long eventTimestamp;
	private int collaboratorId;
	private String collaboratorName;
	private String fileId;
	private String fileName;
	
	public BoxCollaborationEventInfo() {
		super();
	}
	
	public BoxCollaborationEventInfo(int eventId, String eventType, long eventTimestamp, int collaboratorId,
			String collaboratorName, String fileId, String fileName) {
		super();
		this.eventId = eventId;
		this.eventType = eventType;
		this.eventTimestamp = eventTimestamp;
		this.collaboratorId = collaboratorId;
		this.collaboratorName = collaboratorName;
		this.fileId = fileId;
		this.fileName = fileName;
	}
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public long getEventTimestamp() {
		return eventTimestamp;
	}
	public void setEventTimestamp(long eventTimestamp) {
		this.eventTimestamp = eventTimestamp;
	}
	public int getCollaboratorId() {
		return collaboratorId;
	}
	public void setCollaboratorId(int collaboratorId) {
		this.collaboratorId = collaboratorId;
	}
	public String getCollaboratorName() {
		return collaboratorName;
	}
	public void setCollaboratorName(String collaboratorName) {
		this.collaboratorName = collaboratorName;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
