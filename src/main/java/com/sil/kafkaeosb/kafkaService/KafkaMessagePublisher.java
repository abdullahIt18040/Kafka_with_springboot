package com.sil.kafkaeosb.kafkaService;

import com.sil.kafkaeosb.events.UserEventRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {
    @Autowired
    KafkaTemplate<String, UserEventRecord>kafkaTemplate;

    public void sendMessageToKafkaTopic(UserEventRecord  userEvent)
    {
        CompletableFuture<SendResult<String, UserEventRecord>> future = kafkaTemplate
                .send("user-event", userEvent);
        future.whenComplete((result,error)->{
    if (error ==null)
    {

        System.out.println("message consume from consumer  send successfully00000000000"+result.getRecordMetadata().offset()
                );
    }else {

        System.out.println("message not send ");
    }

        });


    }

}
