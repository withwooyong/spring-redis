package com.example.springredis.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@SpringBootTest
class TestServiceTest {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @BeforeEach
    void setUp() {
    }

    @Test
    void hello() {
        String key = "aggregate::6226407::12138";
//        String key = "v2::aggregate::6647843::1273970";
        Object o = redisTemplate.opsForValue().get(key);
        log.info("{}", o);
    }

    @Test
    void redisKeys() {
//        String key = "v2::aggregate::6647843::1273970";
        Set<String> keys = redisTemplate.keys("*");

        Set<String> resultType = new HashSet<>();
        assert keys != null;
        for (String resultKey : keys) {
            DataType type = redisTemplate.type(resultKey);
            log.info("key={} type={}", resultKey, type);
            assert type != null;
            resultType.add(type.toString());
        }

        System.out.println("===========");
        for (String s : resultType) {
            log.info("type={}", s);
        }
        // SET, STRING, LIST, HASH


    }

    @Test
    void listExam() {
//        redisTemplate.opsForList().rightPush("key", "value");
        RedisOperations<String, Object> operations = redisTemplate.opsForList().getOperations();
        String key = "popup::info";
        List<Object> range = operations.opsForList().range(key, 0, -1);
        for (Object o : range) {
            log.info("{}", o);
        }
//        System.out.println(operations.opsForList().range(key, 0, -1));  // Redis Data List 출력
    }

    @Test
    void setExam() {
        String key = "refresh_token::6226407";
        SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
//        setOperations.add("Key", value);
        System.out.println(setOperations.pop(key));       // 하나 꺼내기 (호출할 때마다 다른 거 꺼내옮)
        Set<Object> members = setOperations.members(key);// 전체 조회
        for (Object member : members) {
            log.info("{}", member);
        }
    }

    @Test
    void sortedSetExam() {
        double score = 10;
        String key = "refresh_token::6226407";
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
//        zSetOperations.add("Key", "Value", score);
        zSetOperations.range("ZKey", 0, -1);
    }

    @Test
    void hashExam() {
//        {"@class":"kr.co.yanadoo.auth.domain.Certification","connectedIp":"127.0.0.1","phoneNumberOrEmailAddress":"01049221429","uuid":"5f6ca2cf-9c3c-4244-9e4d-b3880cf94b6c","certKey":"d419705f5565cfddaf5f133021a8bdee52f0aa9e10cf1dd885b9655aa9698d5a","certNumber":"498126","certExpiredDateTime":["java.math.BigDecimal",20220801160228],"expiredTimeMinute":5,"certNumberLength":6}
        String key = "certification";
        String hashKey = "6647843";
        Object o = redisTemplate.opsForHash().get(key, hashKey);
        log.info("{}", o);
    }
}