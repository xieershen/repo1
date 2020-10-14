package com.cms.portal.controller.admin;

import com.cms.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @GetMapping("test")
    public String test(){
        redisTemplate.opsForValue().set("xiejie","dwfwf");
        String xiejie = redisTemplate.opsForValue().get("xiejie");
        System.out.println(xiejie);
        return "/admin/test/index";
    }

}
