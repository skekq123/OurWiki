package com.one.ourwiki.responsedto;

import com.one.ourwiki.domain.Post;
import lombok.*;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDetailResponseDto {
    private Long post_id;
    private String title;
    private String writer;
    private String category;
    private int likes;
    private String desc;
    private String password;
    private String modifiedAt;
    List<ContributorResponseDto> contributors;
    List<CommentResponseDto> comments;

    public PostDetailResponseDto(Post post, List<ContributorResponseDto> contributorResponseDto, List<CommentResponseDto> commentResponseDto){
        this.post_id = post.getId();
        this.title = post.getTitle();
        this.writer = post.getWriter();
        this.category = post.getCategory();
        this.likes = post.getLikes();
        this.desc = post.getDesc();
        this.password = post.getPassword();
        this.contributors = contributorResponseDto;
        this.comments = commentResponseDto;
        String modifiedAt = post.getCreatedAt().toString();
        String date = modifiedAt.substring(0,10);
        String time = modifiedAt.substring(11,19);
        modifiedAt = date + " " + time;
        this.modifiedAt = modifiedAt;
    }
}