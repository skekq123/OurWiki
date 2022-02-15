package com.one.ourwiki.requestdto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDto {
    private String comment_writer;
    private String comment_desc;
}
