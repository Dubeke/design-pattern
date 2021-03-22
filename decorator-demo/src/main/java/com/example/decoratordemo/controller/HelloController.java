package com.example.decoratordemo.controller;

import com.example.decoratordemo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println(helloService);
        helloService.hello(name);
        return "OK";
    }

}
