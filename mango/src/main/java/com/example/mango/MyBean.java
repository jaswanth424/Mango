package com.example.mango;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class MyBean implements InitializingBean, DisposableBean, Lifecycle {

    public MyBean() {
        System.out.println("=============== Constructor - MyBean is being created.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("=============== InitializingBean - afterPropertiesSet() method is called.");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("=============== @PostConstruct - postConstruct() method is called.");
    }

    public void customInit() {
        System.out.println("=============== Custom Init Method - customInit() method is called.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("=============== @PreDestroy - preDestroy() method is called.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("=============== DisposableBean - destroy() method is called.");
    }

    public void customDestroy() {
        System.out.println("=============== Custom Destroy Method - customDestroy() method is called.");
    }

	@Override
	public void start() {
		System.out.println("=============== START ");
		
	}

	@Override
	public void stop() {
		System.out.println("=============== STOP ");
		
	}

	@Override
	public boolean isRunning() {
		System.out.println("=============== is running-");
		return true;
	}
}
