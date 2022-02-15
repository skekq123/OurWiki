package com.one.ourwiki.responsedto;

import com.one.ourwiki.domain.Comment;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {
    private String comment_writer;
    private String comment_desc;
    private LocalDateTime createdAt;

    public CommentResponseDto(Comment comment) {
        this.comment_writer = comment.getCommentWriter();
        this.comment_desc = comment.getCommentDesc();
        this.createdAt = comment.getModifiedAt();
    }
}
