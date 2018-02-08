package com.epam.spring.sbilorys;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.util.Date;
import java.util.Optional;

@Getter
@Setter
public class Event {
    private int id;
    private String message;
    @NonNull
    private Date date;
    @NonNull
    private DateFormat dateFormat;

    public Event(int id, String messag) {
        this.id = id;
        this.message = message;
        this.date = date;
    }

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    @Override
    public String toString() {
        Optional<Date> date = Optional.<Date> ofNullable(this.date);
        Optional<DateFormat> dateFormat = Optional.<DateFormat> ofNullable(this.dateFormat);
        return dateFormat.map(df -> df.format(date.get())).orElse("the event has initiated without date objects.");

    }
}
