package com.sil.kafkaeosb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaEosbApplication{


    public static void main(String[] args) {
        SpringApplication.run(KafkaEosbApplication.class, args);



    }

}
