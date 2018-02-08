package com.epam.spring.sbilorys;

import com.epam.spring.sbilorys.autowired.AppAutowired;
import com.epam.spring.sbilorys.loggers.UniversalEventLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(UniversalEventLogger.class.getSimpleName());

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        App app = applicationContext.getBean("app", App.class);
        app.tryToLog();
        App cachedApp = applicationContext.getBean("cachedApp", App.class);
        cachedApp.tryToLog();
        Event event = applicationContext.getBean(Event.class);
        LOG.error(event.toString());
        applicationContext.close();
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
                AppAutowired.class);

    }
}
