package com.paychex.pcdcmsgproc.boxCollaborationEvent.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.paychex.pcdcmsgproc.boxCollaborationEvent.schema.BoxCollaborationEvent;


@Service
public class CollaborationEventProducer {

    @Value("${avro.topic.name}")
    String topicName;

    @Autowired
    private KafkaTemplate<String, BoxCollaborationEvent> kafkaTemplate;
    
    public void send(BoxCollaborationEvent boxCollaborationEvent){
        @SuppressWarnings("unchecked")
		ListenableFuture<SendResult<String,BoxCollaborationEvent>> future=  (ListenableFuture<SendResult<String, BoxCollaborationEvent>>) kafkaTemplate.send(topicName,String.valueOf(boxCollaborationEvent.getEventId()),boxCollaborationEvent);
        future.addCallback(new ListenableFutureCallback<SendResult<String, BoxCollaborationEvent>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Message failed to produce");
            }

            @Override
            public void onSuccess(SendResult<String, BoxCollaborationEvent> result) {
                System.out.println("Avro message successfully produced");
            }
        });

     }
}
