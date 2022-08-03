package com.example.springredis.controller;

import com.example.springredis.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping(path = "/redis")
@RestController
public class RedisController {

    @GetMapping()
    @Cacheable(value = "user", cacheManager = "userCacheManager")
    public UserDto get(@RequestParam(value = "id") String id,
                       @RequestParam(value = "name") String name,
                       @RequestParam(value = "age") int age) {
        log.info("get user - userId:{}", id);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new UserDto(id, name, age);
    }

    @DeleteMapping()
    @CacheEvict(value = "user", cacheManager = "userCacheManager")
    public void delete(@RequestParam(value = "id") String id,
                       @RequestParam(value = "name") String name,
                       @RequestParam(value = "age") int age) {
        log.info("delete user - userId:{}", id);
    }

}
