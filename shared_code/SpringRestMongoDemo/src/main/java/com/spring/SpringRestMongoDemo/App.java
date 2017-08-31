package com.spring.SpringRestMongoDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value="beans.xml")
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
