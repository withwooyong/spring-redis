package com.example.springredis.controller;

import com.example.springredis.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping(path = "/")
    public void hello(String key) {
        testService.hello(key);
    }

    /**
     * 리스트
     */
    public void listExam(String key) {
        testService.listExam(key);
    }

    /**
     * Set
     */
    public void setExam(String key) {
        testService.setExam(key);
    }

    /**
     * sorted set
     */
    public void sortedSetExam(String key) {
        testService.sortedSetExam(key);
    }

    public void hashExam(String key) {
        testService.hashExam(key);
    }
}
