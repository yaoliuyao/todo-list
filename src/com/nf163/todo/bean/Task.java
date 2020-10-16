package com.nf163.todo.bean;

import java.util.Date;

public class Task {
    private long id;
    private String body;
    private int state; // 1, 2, 8, 9
    private Date created;

    public Task() {
    }

    public Task(String body) {
        this.body = body;
        this.state = 1;
    }

    public Task(String body, int state) {
        this.body = body;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
