package com.one.ourwiki.service;

import com.one.ourwiki.domain.Comment;
import com.one.ourwiki.domain.Post;
import com.one.ourwiki.repository.CommentRepository;
import com.one.ourwiki.repository.PostRepository;
import com.one.ourwiki.requestdto.CommentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public Comment createComment(Long postId, CommentRequestDto commentRequestDto) {
        Post post = postRepository.getById(postId);
        Comment comment = new Comment(post, commentRequestDto);
        commentRepository.save(comment);

        return comment;
    }

    public List<Comment> getComments(Long postId) {
        List<Comment> comments = commentRepository.getCommentsByPostId(postId);
        return comments;
    }
}
