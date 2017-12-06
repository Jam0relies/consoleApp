package com.github.jam0relies.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Task {
    private String name;
    private String description;
    private Timestamp notification;
    private String contacts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getNotification() {
        return notification;
    }

    public void setNotification(Timestamp notification) {
        this.notification = notification;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
