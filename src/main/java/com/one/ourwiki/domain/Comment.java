package com.one.ourwiki.domain;


import com.one.ourwiki.requestdto.CommentRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Comment extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="comment_id")
    private Long id;

    @Column(nullable = false)
    private String commentWriter;

    @Column(nullable = false)
    private String commentDesc;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    public Comment(Post post, CommentRequestDto commentRequestDto) {
        this.commentWriter = commentRequestDto.getComment_writer();
        this.commentDesc = commentRequestDto.getComment_desc();
        this.post = post;
    }
}
