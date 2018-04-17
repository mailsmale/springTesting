package com.epam.spring.sbilorys.autowired;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(LoggersConfig.class)
public class AppAutowired {


}
