package com.paychex.pcdcmsgproc.boxCollaborationEvent.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.paychex.pcdcmsgproc.boxCollaborationEvent.schema.BoxCollaborationEvent;

@Service
public class CollaborationEventConsumer {

    @KafkaListener(topics = "${avro.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void read(ConsumerRecord<String, BoxCollaborationEvent> record){
        String key=record.key();
        BoxCollaborationEvent event=record.value();
        System.out.println("Avro message received for key: "+key+ "and value : "+event.toString());
    }
}
