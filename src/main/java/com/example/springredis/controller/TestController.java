package com.example.springredis.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final RedisTemplate<String, Object> redisTemplate;
    private final RedisTemplate<String, Object> redisTemplateLocal;

    @GetMapping(path = "/")
    public void hello(){
        String key = "attendance::6636837";
//        log.info(Objects.requireNonNull(redisTemplateLocal.opsForValue().get(key)).toString());
        log.info(Objects.requireNonNull(redisTemplate.opsForValue().get(key)).toString());

    }

    /**
     * 리스트
     */
    public void listExam() {


        redisTemplate.opsForList().rightPush("key", "value");
        RedisOperations<String, Object> operations = redisTemplate.opsForList().getOperations();
        String idx = "1";
        System.out.println(operations.opsForList().range("chatNumber" + idx, 0, -1));  // Redis Data List 출력
    }

    /**
     * Set
     */
    public void setExam() {

        String chatMessage = "value";
        SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
        setOperations.add("Key", chatMessage);
        System.out.println(setOperations.pop("Key"));       // 하나 꺼내기
        System.out.println(setOperations.members("Key"));  // 전체 조회
    }

    /**
     * sorted set
     */
    public void sortedSetExam() {
        double score = 10;
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("Key", "Value", score);
        System.out.println(zSetOperations.range("ZKey", 0, -1));
    }


    public void hashExam() {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        Map<String, Object> map = new HashMap<>();
        map.put("firstName", "Gyunny");
        map.put("lastName", "Choi");
        map.put("gender", "Man");
        hashOperations.putAll("key", map);

        String firstName = (String) redisTemplate.opsForHash().get("key", "firstName");
        String lastName = (String) redisTemplate.opsForHash().get("key", "lastName");
        String gender = (String) redisTemplate.opsForHash().get("key", "gender");
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(gender);
    }

}
