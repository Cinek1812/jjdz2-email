package com.jbd;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Email {
    private String from;
    private LocalDate data;
    private String subject;
    private String content;

    LocalDate objectOfDate;

    public Email(String from, String subject, String data, String content) {
        this.from = from;
        //objectOfDate = LocalDate.parse(data);
        DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;
        //LocalDateTime dateTime = LocalDateTime.parse(data, formatter);
        //this.data = objectOfDate;
        this.data = LocalDate.parse(data, formatter);
        this.subject = subject;
        this.content = content;
    }

    public Email(String from, String subject) {
        this.from = from;
        this.subject = subject;

    }
    public Email(String from) {
        this.from = from;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(String data) {
        objectOfDate = LocalDate.parse(data);
//        try {
//            objectOfDate = simpleDateFormat.parse(data);
//            this.data = objectOfDate;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "From: " + from + "\nSubject: " + subject + "\n";
    }
}
