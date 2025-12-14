package com.sil.kafkaeosb.kafkaService;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class RuningBean implements SmartLifecycle {
    @Override
    public void start() {
        System.out.println("some task continue...............");
    }

    @Override
    public void stop() {
        System.out.println("clean the resource..........");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
