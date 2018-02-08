package com.epam.spring.sbilorys.autowired;

import com.epam.spring.sbilorys.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class AppAutowired {

    @Autowired
    Client client;

    @Bean
    public Client getClient(){
        return new Client();
    }

}
