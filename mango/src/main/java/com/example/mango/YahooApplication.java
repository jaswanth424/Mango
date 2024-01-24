package com.example.mango;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class YahooApplication {
	
    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public MyBean myBean() {
        return new MyBean();
    }
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(YahooApplication.class, args);
		
//		Stream.of(List.of(ctx.getBeanDefinitionNames())).sorted().forEach(System.out::println);
//		
//		
//	    String[] beanNames = ctx.getBeanDefinitionNames();
//	    Arrays.sort(beanNames);

	   for (String beanName : args) {
		   System.out.println("----------------------------------------------------------");
	     System.out.println("=========== jaswanth ================="+ beanName);
	     System.out.println("----------------------------------------------------------");
	    }

	}

}
