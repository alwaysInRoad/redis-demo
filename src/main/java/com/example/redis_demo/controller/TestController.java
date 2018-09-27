package com.example.redis_demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/set")
    public void set() {
        redisTemplate.opsForValue().set("test003", "你好吗？");
    }

    @RequestMapping("/show")
    public String show(){
        logger.info(redisTemplate.opsForValue().get("test003").toString());
        return "Hello World";
    }
}
