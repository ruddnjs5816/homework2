package com.example.homework1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreatePostRequest {
    private String title;
    private String username;
    private Long password;
    private String contents;

    public CreatePostRequest(String title, String username, Long password, String contents) {
        this.title = title;
        this.username = username;
        this.password = password;
        this.contents = contents;
    }



}
