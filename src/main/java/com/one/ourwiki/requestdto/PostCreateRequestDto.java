package com.one.ourwiki.requestdto;

import lombok.Getter;

@Getter
public class PostCreateRequestDto {
    private String title;
    private String writer;
    private String category;
    private String desc;
    private String password;
}
