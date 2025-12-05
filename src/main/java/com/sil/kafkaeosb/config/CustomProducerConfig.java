package com.sil.kafkaeosb.config;


import com.fasterxml.jackson.databind.JsonSerializer;
import com.sil.kafkaeosb.events.OrderRecord;
import com.sil.kafkaeosb.events.UserEventRecord;
import com.sil.kafkaeosb.serialization.OrderEventSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class CustomProducerConfig {

    @Bean

    public KafkaTemplate<String, OrderRecord> orderEventkafkaTemplate() {

        KafkaTemplate<String, OrderRecord> orderRecordkafkaTemplate = new KafkaTemplate(
                kafkaProducerFactoryForOrderEvent());


        return orderRecordkafkaTemplate;
    }
    @Bean
    public DefaultKafkaProducerFactory<String, OrderRecord> kafkaProducerFactoryForOrderEvent() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, List.of("localhost:9092"));
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, OrderEventSerializer.class);

        DefaultKafkaProducerFactory<String, OrderRecord> factory = new DefaultKafkaProducerFactory(properties);


        return factory;
    }

    @Bean

    public KafkaTemplate<String, UserEventRecord> kafkaTemplate() {

        KafkaTemplate<String, UserEventRecord> kafkaTemplate = new KafkaTemplate(
                kafkaProducerFactoryForUserEvent());


        return kafkaTemplate;
    }
    @Bean
    public DefaultKafkaProducerFactory<String, UserEventRecord> kafkaProducerFactoryForUserEvent() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, List.of("localhost:9092"));
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);

        DefaultKafkaProducerFactory<String, UserEventRecord> factory = new DefaultKafkaProducerFactory(properties);


        return factory;
    }

}
