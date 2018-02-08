package com.epam.spring.sbilorys.loggers;

import java.io.File;
import java.util.Optional;

import com.epam.spring.sbilorys.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniversalEventLogger extends EventLogger {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public UniversalEventLogger(Client client) {
        super(client);
    }

    @Override
    public String logEvent(String msg, EVENT_IMPORTANTCY importantcy) {
        Optional<Client> clientWrapped = Optional.ofNullable(this.client);
        StringBuilder stringBuilder = new StringBuilder();
        clientWrapped.ifPresent(
                client -> stringBuilder.append(msg.replaceAll(String.valueOf(client.getId()), client.getName())));
        if(EVENT_IMPORTANTCY.ERROR == importantcy){
            logger.error(String.valueOf(stringBuilder));
        }
        return msg;
    }

    protected void initBean(){
        File file = new File("log.txt");
        if (false ==  file.canWrite()){
            throw new ExceptionInInitializerError("Can not read file 'log.txt'!");
        }
    }
}
