package com.company.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yulia on 29.10.16.
 */
public class Main {


    public static void main(String[] args)  {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("WEB-INF/application-context.xml");
    }


}
