package com.epam.spring.sbilorys;

import com.epam.spring.sbilorys.loggers.EVENT_IMPORTANTCY;
import com.epam.spring.sbilorys.loggers.EventLogger;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
public class App {
    @NonNull
    private EventLogger eventLogger;
    private EVENT_IMPORTANTCY event_importantcy;

    public void tryToLog() {
        eventLogger.logEvent("Hello from user 1", event_importantcy);
        int id = 2;
        eventLogger.setClient(new Client(id, "Petro", "hi"));
        eventLogger.logEvent(String.format("Hello from user %s", id), event_importantcy);
        eventLogger.logEvent(String.format("Hello from user %s", id), event_importantcy);
        eventLogger.logEvent(String.format("Hello from user %s", id), event_importantcy);

    }
}
