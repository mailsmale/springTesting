package com.epam.spring.sbilorys;

import com.epam.spring.sbilorys.loggers.Key;

import java.util.HashMap;
import java.util.Map;

public class Session {

    private static HashMap<Key, Object> sessionMap = new HashMap<>();
    private Session(){}

    public static <T> T getFromSession(final Key key){
        return (T) sessionMap.get(key);
    }

    public static <T> T putToSession(final Key key, final Object value){
        return (T) sessionMap.<T>put(key, value);
    }
}

