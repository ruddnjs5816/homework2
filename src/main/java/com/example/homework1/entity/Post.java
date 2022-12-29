package com.example.homework1.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Entity
public class Post extends TimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id = 0L;

    private String title;
    private String username;
    private Long password;
    private String contents;


    public Post(String title, String username, Long password, String contents) {
        this.title = title;
        this.username = username;
        this.password = password;
        this.contents = contents;

    }

    public Post() {
    }

    public void update(String title, String username, String contents) {
        this.title = title;
        this.username = username;
        this.contents = contents;
    }

    public boolean isValidPassword(Long inputPassword) {
        if (inputPassword.equals(this.password)) return true;
        else return false;
    }


}
