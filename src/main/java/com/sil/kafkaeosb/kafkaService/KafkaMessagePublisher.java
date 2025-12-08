package com.sil.kafkaeosb.kafkaService;

import com.sil.kafkaeosb.events.MyEvent;
import com.sil.kafkaeosb.events.OrderRecord;
import com.sil.kafkaeosb.events.UserEventRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    KafkaTemplate<String, OrderRecord>orderRecordKafkaTemplate;

    public void sendDataToKafkafororderrecord(OrderRecord event)
    {
        CompletableFuture<SendResult<String, OrderRecord>> future=
                orderRecordKafkaTemplate.send("ordereventtest",event);
        future.whenComplete((result,err)->{
            if (err ==null)
            {

                System.out.println("message produce from " +
                        "producer myevent  send " +
                        "successfully00000000000"+result.getRecordMetadata().offset()
                );
            }else {

                System.out.println("message not send ");
            }

        });

    }

    @Autowired
    KafkaTemplate<String, UserEventRecord>kafkaTemplate;

    public void sendDataToKafka(UserEventRecord event)
    {
        CompletableFuture<SendResult<String, UserEventRecord>> future=
                kafkaTemplate.send("sdlcpro",event);
        future.whenComplete((result,err)->{
            if (err ==null)
            {

                System.out.println("message produce from " +
                        "producer myevent  send " +
                        "successfully00000000000"+result.getRecordMetadata().offset()
                );
            }else {

                System.out.println("message not send ");
            }

        });

    }

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
