package com.one.ourwiki.responsedto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    private Long post_id;
    private String title;
    private String writer;
    private String category;
    private LocalDateTime modifiedAt;
    private int likes;
    private String desc;
    private int comment_count;
}
