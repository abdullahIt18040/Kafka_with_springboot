package com.sil.kafkaeosb.events;

public record UserEventRecord(String name,
                              String email,
                              String action) {



}
