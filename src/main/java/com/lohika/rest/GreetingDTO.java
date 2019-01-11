package com.lohika.rest;

public class GreetingDTO {

    private String id;
    private String content;

    public GreetingDTO(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }
}
