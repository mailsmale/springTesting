package com.epam.spring.sbilorys.loggers;

import com.epam.spring.sbilorys.Client;
import com.epam.spring.sbilorys.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CachedUniversalEventLogger extends UniversalEventLogger {

    @Autowired
    @Qualifier("client1")
    Client client;

    @Value("123")
    private int exampleInt;

    private List<String> events;

    public CachedUniversalEventLogger(final Client client) {
        super(client);
        events = new ArrayList<String>();
        Session.putToSession(Key.EVENTS, events);
    }

    @Override
    public String logEvent(final String message, final EVENT_IMPORTANTCY importantcy){
        String formattedMessage = super.logEvent(message, importantcy);
        events.add(message);
        int size = events.size();
        if (size >= 5){
            logAndFlushCache();
        }
        return formattedMessage;
    }

    @PostConstruct
    private void init(){
        super.initBean();
    }

    @PreDestroy
    private void destroyBean(){
        Optional.ofNullable(events).ifPresent(listOfEvents -> {
            if(!listOfEvents.isEmpty()){
                logAndFlushCache();
            }
        });
    }

    private void logAndFlushCache(){
        logger.error(String.format("write bulk of %s messages into file", events.size()));
        events.clear();
    }




}
