package com.android.isp_application;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "schedule")
public class ScheduleEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String date;  // Date of the event
    private String event; // Event name or description
    private String time;  // Time of the event

    // Constructor
    public ScheduleEntity(String date, String event, String time) {
        this.date = date;
        this.event = event;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
