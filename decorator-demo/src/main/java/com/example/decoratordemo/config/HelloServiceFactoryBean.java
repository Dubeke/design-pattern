package com.example.decoratordemo.config;

import com.example.decoratordemo.service.HelloService;
import com.example.decoratordemo.service.impl.HelloServiceImpl;
import com.example.decoratordemo.service.impl.decorate.HelloServiceCacheDecorate;
import com.example.decoratordemo.service.impl.decorate.HelloServiceDecorate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloServiceFactoryBean  implements FactoryBean<HelloService>, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private HelloService instance;

    @Override
    public HelloService getObject() throws Exception {
        if (instance == null) {
            instance = new HelloServiceImpl();
            //applicationContext.getAutowireCapableBeanFactory().autowireBean(instance); //依赖注入
            instance = new HelloServiceDecorate(instance);
            //applicationContext.getAutowireCapableBeanFactory().autowireBean(instance); //依赖注入
            instance = new HelloServiceCacheDecorate(instance);
            applicationContext.getAutowireCapableBeanFactory().autowireBean(instance); //依赖注入
        }
        return instance;
    }

    @Override
    public Class<?> getObjectType() {
        return HelloService.class;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
