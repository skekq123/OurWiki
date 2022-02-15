package com.one.ourwiki.repository;

import com.one.ourwiki.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostId(Long id);
    List<Comment> getCommentsByPostId(Long postId);
}
