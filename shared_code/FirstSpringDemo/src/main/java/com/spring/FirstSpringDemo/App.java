package com.spring.FirstSpringDemo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
MessagePrinterBean bean = (MessagePrinterBean)iocContainer.getBean("messagePrinter");
System.out.println("Bean message: " + bean.getMessage());
    }
}
