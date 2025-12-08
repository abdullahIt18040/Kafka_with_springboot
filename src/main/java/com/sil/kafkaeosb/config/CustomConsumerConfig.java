package com.sil.kafkaeosb.config;

import com.sil.kafkaeosb.events.OrderRecord;
import com.sil.kafkaeosb.serialization.OrderEventDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class CustomConsumerConfig {

    @Bean
    public DefaultKafkaConsumerFactory<String, OrderRecord>OrderfEventConsumerFactory()
    {
        Map<String,Object>pros =new HashMap<>();
        pros.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, List.of("localhost:9092"));
        pros.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        pros.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, OrderEventDeserializer.class);
        pros.put(ConsumerConfig.GROUP_ID_CONFIG, "order-event-group-1");
        pros.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        return new DefaultKafkaConsumerFactory<>(pros);
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,OrderRecord>
    orderEventKafkaListenerContainerFactory()
    {
        ConcurrentKafkaListenerContainerFactory<String,OrderRecord>factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(OrderfEventConsumerFactory());
        return factory;
    }



}
