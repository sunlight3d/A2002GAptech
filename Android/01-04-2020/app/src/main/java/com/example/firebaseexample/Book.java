package com.example.firebaseexample;

import java.io.Serializable;
import java.security.Key;
import java.util.HashMap;

public class Book implements Serializable {
    private String name;
    private Long year;
    private String author;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Book(String name, Long year, String author, String url) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.url = url;
    }

    public static Book getFromHashMap(HashMap<String, Object> map) {
        String name = (String)map.get("name");
        Long year = (Long)map.get("year");
        String author = (String)map.get("author");
        String url = (String)map.get("url");
        return new Book(name, year, author, url);
    }
}
