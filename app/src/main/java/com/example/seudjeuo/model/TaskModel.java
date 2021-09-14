package com.example.seudjeuo.model;

import java.io.Serializable;

public class TaskModel implements Serializable {

    private int photo;
    public String title;

    public TaskModel(int photo, String title) {
        this.photo = photo;
        this.title = title;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
