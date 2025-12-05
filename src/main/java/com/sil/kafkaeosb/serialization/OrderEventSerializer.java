package com.sil.kafkaeosb.serialization;

import com.sil.kafkaeosb.events.OrderRecord;
import com.sil.kafkaeosb.utility.AESUtil;
import org.apache.kafka.common.serialization.Serializer;

import java.util.StringJoiner;
import java.util.stream.Collectors;

public class OrderEventSerializer implements Serializer<OrderRecord> {


    @Override
    public byte[] serialize(String s, OrderRecord orderRecord) {
        StringJoiner joiner = new StringJoiner(":");
        joiner.add(String.valueOf(orderRecord.orderId()));
        joiner.add(String.valueOf(orderRecord.userId()));
      String orderItems = String.join(",", orderRecord.items());
      joiner.add(orderItems);
        String plainText = joiner.toString();

        // Encrypt here
        String encrypted = AESUtil.encrypt(plainText);

        return encrypted.getBytes();
    }

}
