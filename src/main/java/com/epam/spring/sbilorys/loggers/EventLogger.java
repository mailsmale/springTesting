package com.epam.spring.sbilorys.loggers;


import com.epam.spring.sbilorys.Client;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public abstract class EventLogger {

    protected Client client;

    public abstract String logEvent(String s, EVENT_IMPORTANTCY event_importantcy);
}
