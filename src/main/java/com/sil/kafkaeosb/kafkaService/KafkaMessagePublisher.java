package com.sil.kafkaeosb.kafkaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {
    @Autowired
    KafkaTemplate<String,Object>kafkaTemplate;

    public void sendMessageToKafkaTopic(String msg)
    {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate
                .send("sdlcpro", msg);
        future.whenComplete((result,error)->{
    if (error ==null)
    {
        System.out.println("message send successfully1111111111111111111"+result.getRecordMetadata().offset()
                );
    }else {
        System.out.println("message not send ");
    }

        });


    }

}
