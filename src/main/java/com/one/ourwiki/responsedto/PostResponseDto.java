package com.one.ourwiki.responsedto;

import com.one.ourwiki.domain.Post;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    private Long post_id;
    private String title;
    private String writer;
    private String category;
    private String modifiedAt;
    private int likes;
    private String desc;
    private int comment_count;

    public PostResponseDto(Post post, int comment_count) {
        this.post_id = post.getId();
        this.title = post.getTitle();
        this.writer = post.getWriter();
        this.category = post.getCategory();
        String modifiedAt = post.getCreatedAt().toString();
        String date = modifiedAt.substring(0,10);
        String time = modifiedAt.substring(11,19);
        modifiedAt = date + " " + time;
        this.modifiedAt = modifiedAt;
        this.likes = post.getLikes();
        this.desc = post.getDesc();
        this.comment_count = comment_count;
    }
}
