package com.sil.kafkaeosb.config;

import com.sil.kafkaeosb.utility.AESUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptionConfig {

    @Value("${app.encryption.key}")
    private String encryptionKey;

    @PostConstruct
    public void init() {
        AESUtil.setKey(encryptionKey);
    }
}
