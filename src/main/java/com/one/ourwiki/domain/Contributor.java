package com.one.ourwiki.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Contributor {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="contributor_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;


    public Contributor(String name){
        this.name = name;
    }
}
