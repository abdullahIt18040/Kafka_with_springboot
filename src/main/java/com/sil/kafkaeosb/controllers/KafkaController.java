package com.sil.kafkaeosb.controllers;

import com.sil.kafkaeosb.events.UserEventRecord;
import com.sil.kafkaeosb.kafkaService.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer-app")
public class KafkaController {
    @Autowired
   private KafkaMessagePublisher kafkaMessagePublisher;

    @GetMapping("/public/{message}")
    public ResponseEntity<?>publishMessage(@PathVariable String message)
    {
        try{
            for(int i=0;i<1;i++)
            {
                UserEventRecord userEventRecord = new UserEventRecord(
                        "abdullah al mamun",
                        "abc@gmail.com",
                        "Notify");
                kafkaMessagePublisher.sendMessageToKafkaTopic(userEventRecord);

            }
            return ResponseEntity.ok("message send successfully ");

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }


    }

}
