package com.one.ourwiki.controller;

import com.one.ourwiki.domain.Comment;
import com.one.ourwiki.requestdto.CommentRequestDto;
import com.one.ourwiki.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment/{postId}")
    public ResponseEntity createComment(@PathVariable Long postId, @RequestBody CommentRequestDto commentRequestDto) {
        Comment comment = commentService.createComment(postId, commentRequestDto);
        if(comment != null) return ResponseEntity.ok().body(null);
        else return ResponseEntity.badRequest().body(null);
    }
}
