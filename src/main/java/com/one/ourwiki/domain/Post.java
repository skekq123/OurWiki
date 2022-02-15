package com.one.ourwiki.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Post extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private int likes;

    @Column(nullable = false)
    private String desc;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @OneToMany(mappedBy = "post")
    private List<Contributor> contributors;
}
