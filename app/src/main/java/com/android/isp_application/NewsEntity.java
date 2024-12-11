package com.android.isp_application;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "news")
public class NewsEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title; // News title
    private String content; // News content
    private String timestamp; // Time when the news was published

    // Constructor
    public NewsEntity(String title, String content, String timestamp) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
