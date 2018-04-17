package com.epam.spring.sbilorys.autowired;


import com.epam.spring.sbilorys.App;
import com.epam.spring.sbilorys.Client;
import com.epam.spring.sbilorys.loggers.EventLogger;
import com.epam.spring.sbilorys.loggers.UniversalEventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class LoggersConfig {


    @Autowired
    App app;

    @Autowired
    EventLogger eventLogger;

    @Autowired
    Client client;

    @Bean
    EventLogger getEventLogger(){
        return new UniversalEventLogger(getClient());
    }

    @Bean
    App getApp(){
        return new App(getEventLogger());
    }

    @Bean
    @Scope("prototype")
    public Client getClient(){
        return new Client();
    }




}
