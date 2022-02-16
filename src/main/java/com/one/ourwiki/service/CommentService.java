package com.one.ourwiki.service;

import com.one.ourwiki.domain.Comment;
import com.one.ourwiki.domain.Post;
import com.one.ourwiki.repository.CommentRepository;
import com.one.ourwiki.repository.PostRepository;
import com.one.ourwiki.requestdto.CommentRequestDto;
import com.one.ourwiki.responsedto.CommentResponseDto;
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

    public List<CommentResponseDto> getComments(Long postId) {
        List<Comment> temporarycomments = commentRepository.getCommentsByPostIdOrderByModifiedAtDesc(postId);
        int commentSize = temporarycomments.size();
        if(commentSize > 20){
            for(int i =20; i<commentSize; i++){
                commentRepository.delete(temporarycomments.get(i));
            }
        }

        List<Comment> comments = commentRepository.getCommentsByPostIdOrderByModifiedAtDesc(postId);

        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();

        for(Comment comment : comments) {
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
            commentResponseDtos.add(commentResponseDto);
        }
        return commentResponseDtos;
    }
}
