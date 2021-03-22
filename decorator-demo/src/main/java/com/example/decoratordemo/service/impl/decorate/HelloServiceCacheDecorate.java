package com.example.decoratordemo.service.impl.decorate;

import com.example.decoratordemo.service.HelloService;

public class HelloServiceCacheDecorate implements HelloService {

    private HelloService helloService;

    public HelloServiceCacheDecorate(HelloService helloService){
        this.helloService = helloService;
        System.out.println("HelloServiceCacheDecorate构造函数,"+helloService);
    }

    @Override
    public String hello(String name){
        System.out.println("hello " + name +" ,HelloServiceCacheDecorate");
        helloService.hello(name);
        return "OK";
    }
}
