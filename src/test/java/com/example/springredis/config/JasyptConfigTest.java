package com.example.springredis.config;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.iv.RandomIvGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class JasyptConfigTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("!JasyptEncoding!");
        config.setAlgorithm("PBEWithHMACSHA512AndAES_256");
        config.setIvGenerator(new RandomIvGenerator());
        config.setKeyObtentionIterations(1000);
        config.setPoolSize(1);
        config.setProviderName("SunJCE");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        String str = "test";
        String encrypt = encryptor.encrypt(str);
        log.info(encrypt);
        String decrypt = encryptor.decrypt(encrypt);
        log.info(decrypt);

    }
}