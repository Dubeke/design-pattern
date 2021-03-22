package com.example.decoratordemo.service.impl.decorate;

import com.example.decoratordemo.service.HelloService;

public class HelloServiceDecorate implements HelloService {

    private HelloService helloService;


    public HelloServiceDecorate(HelloService helloService){
        this.helloService = helloService;
        System.out.println("HelloServiceDecorate构造函数,"+helloService);
    }

    @Override
    public String hello(String name){
        System.out.println("hello " + name +" ,HelloServiceDecorate");
        helloService.hello(name);
        return "OK";
    }
}
