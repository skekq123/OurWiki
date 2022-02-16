package com.one.ourwiki.domain;

import com.one.ourwiki.repository.PostRepository;
import com.one.ourwiki.requestdto.PostCreateRequestDto;
import com.one.ourwiki.requestdto.PostModifyRequestDto;
import com.one.ourwiki.responsedto.PostResponseDto;
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

    @Column(nullable = false,length = 65000)
    private String desc;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "post", cascade=CascadeType.REMOVE)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post",cascade=CascadeType.REMOVE)
    private List<Contributor> contributors;
    
    public Post(PostCreateRequestDto PostCreateRequestDto){
        this.title = PostCreateRequestDto.getTitle();
        this.writer= PostCreateRequestDto.getWriter();
        this.category=PostCreateRequestDto.getCategory();
        this.password=PostCreateRequestDto.getPassword();
        this.desc=PostCreateRequestDto.getDesc();
        this.likes=0;
    }

    public Post(String title, String writer, String category, int likes, String desc, String password) {
        this.title = title;
        this.writer = writer;
        this.category = category;
        this.likes = likes;
        this.desc = desc;
        this.password = password;
    }

    public void modify(String desc, Contributor contributor){
        this.desc = desc;
        this.contributors.add(contributor);
        contributor.setPost(this);
    }

    public void like(int likes){
        this.likes += likes;
    }
}
