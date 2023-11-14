package com.paychex.pcdcmsgproc.boxCollaborationEvent.config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import com.paychex.pcdcmsgproc.boxCollaborationEvent.schema.BoxCollaborationEvent;

@Configuration
public class Config {

    @Bean
    public ConsumerFactory<String, BoxCollaborationEvent> consumerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, BoxCollaborationEvent>> kafkaListenerContainerFactory(KafkaProperties kafkaProperties) {
        ConcurrentKafkaListenerContainerFactory<String, BoxCollaborationEvent> factory = new ConcurrentKafkaListenerContainerFactory<String, BoxCollaborationEvent>();
        factory.setConsumerFactory(consumerFactory(kafkaProperties));
        return factory;
    }
}
