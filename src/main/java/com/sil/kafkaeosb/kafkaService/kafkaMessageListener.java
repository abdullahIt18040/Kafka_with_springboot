package com.sil.kafkaeosb.kafkaService;

import com.sil.kafkaeosb.events.MyEvent;
import com.sil.kafkaeosb.events.OrderRecord;
import com.sil.kafkaeosb.events.UserEventRecord;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaMessageListener {

    @KafkaListener(topics = "sdlcpro",groupId = "my-group22")
    public void consumerMyEvent(MyEvent data)
    {
        System.out.println("Spring boot consumer consume data my event data receivce................................................... "+data);
    }


    @KafkaListener(topics = "user-event",groupId = "my-group21")
    public void consumer21(UserEventRecord data)
    {
        System.out.println("Spring boot consumer data receivce...." +
                "............................................... "+data);
    }


    @KafkaListener(topics = "ordereventtest",
            groupId = "order-event-group-1",
            containerFactory = "orderEventKafkaListenerContainerFactory")
public void consumeOrderEvent(OrderRecord orderRecord)
{
    System.out.println("ORDER RECORD IS 88888888888888888888888888888"+orderRecord);
}




//    @KafkaListener(topics = "ordertopic",groupId = "my-group21")
//    public void consumerordertopic(OrderRecord data)
//    {
//        System.out.println("Spring boot consumer data receivce...." +
//                "............................................... "+data);
//    }







}
