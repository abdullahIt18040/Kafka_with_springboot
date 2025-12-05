package com.sil.kafkaeosb.events;

import java.util.List;

public record OrderRecord(Long orderId, Long userId, List<String>items) {

    
}
