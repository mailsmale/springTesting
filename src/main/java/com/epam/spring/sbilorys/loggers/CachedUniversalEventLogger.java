package com.epam.spring.sbilorys.loggers;

import com.epam.spring.sbilorys.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CachedUniversalEventLogger extends UniversalEventLogger {

    List<String> events;

    public CachedUniversalEventLogger(Client client) {
        super(client);
        events = new ArrayList<>();
    }

    @Override
    public String logEvent(String message, EVENT_IMPORTANTCY importantcy){
        String formattedMessage = super.logEvent(message, importantcy);
        events.add(message);
        int size = events.size();
        if (size >= 5){
            logAndFlushCache();
        }
        return formattedMessage;
    }

    private void init(){
        super.initBean();
    }

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
