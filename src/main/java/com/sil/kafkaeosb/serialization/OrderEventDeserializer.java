package com.sil.kafkaeosb.serialization;

import com.sil.kafkaeosb.events.OrderRecord;
import com.sil.kafkaeosb.utility.AESUtil;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Arrays;
import java.util.List;

public class OrderEventDeserializer implements Deserializer<OrderRecord> {


    @Override
    public OrderRecord deserialize(String s, byte[] bytes) {

        String encrypted = new String(bytes);
        // Decrypt here
        String decrypted = AESUtil.decrypt(encrypted);
        // Split fields
        String[] parts = decrypted.split(":");

        Long orderId = Long.parseLong(parts[0]);
        Long userId = Long.parseLong(parts[1]);
        String[] items = parts[2].split(",");
        return new OrderRecord(orderId, userId, List.of(items));
    }
}
