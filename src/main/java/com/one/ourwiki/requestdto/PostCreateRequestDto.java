package com.one.ourwiki.requestdto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class PostCreateRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private String writer;
    @NotBlank
    private String category;
    @NotBlank
    private String desc;
    @NotBlank
    private String password;
}
