package com.one.ourwiki.repository;

import com.one.ourwiki.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
