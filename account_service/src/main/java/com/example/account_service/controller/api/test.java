package com.example.account_service.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("account")
@RestController
public class test {

    @GetMapping("test")
    public String get() {
        return "test-ok";
    }

    @GetMapping(value = "/hello")
    public String getValue(){
        return "HelloWorld";
    }
}
