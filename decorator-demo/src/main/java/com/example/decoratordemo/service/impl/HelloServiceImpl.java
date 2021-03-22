package com.example.decoratordemo.service.impl;

import com.example.decoratordemo.service.HelloService;

public class HelloServiceImpl implements HelloService {

    public HelloServiceImpl(){
        System.out.println("HelloServiceImpl构造函数");
    }

    @Override
    public String hello(String name){
        System.out.println("hello " + name +" ,HelloServiceImpl");
        return "OK";
    }
}
