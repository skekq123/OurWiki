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
    private LocalDateTime modifiedAt;
    private int likes;
    private String desc;
    private int comment_count;

    public PostResponseDto(Post post, int comment_count) {
        this.post_id = post.getId();
        this.title = post.getTitle();
        this.writer = post.getWriter();
        this.category = post.getCategory();
        this.modifiedAt = post.getModifiedAt();
        this.likes = post.getLikes();
        this.desc = post.getDesc();
        this.comment_count = comment_count;
    }
}
