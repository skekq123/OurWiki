package com.one.ourwiki.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Comment {

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
}
