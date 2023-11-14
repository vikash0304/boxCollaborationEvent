package com.paychex.pcdcmsgproc.boxCollaborationEvent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paychex.pcdcmsgproc.boxCollaborationEvent.model.BoxCollaborationEventInfo;
import com.paychex.pcdcmsgproc.boxCollaborationEvent.producer.CollaborationEventProducer;
import com.paychex.pcdcmsgproc.boxCollaborationEvent.schema.BoxCollaborationEvent;

@RestController
@RequestMapping("/collaboration")
public class CollaborationEventController {

	@Autowired
	private CollaborationEventProducer producer;

	@PostMapping(value = "/event")
	public void sendStockHistory(@RequestBody BoxCollaborationEventInfo info) {
		producer.send(new BoxCollaborationEvent(info.getEventId(), info.getEventType(), info.getEventTimestamp(),
				info.getCollaboratorId(), info.getCollaboratorName(), info.getFileId(), info.getFileName()));
	}
}
