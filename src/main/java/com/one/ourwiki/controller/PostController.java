package com.one.ourwiki.controller;

import com.one.ourwiki.domain.Post;
import com.one.ourwiki.requestdto.PostCreateRequestDto;
import com.one.ourwiki.requestdto.PostDeleteRequestDto;
import com.one.ourwiki.requestdto.PostLikeRequestDto;
import com.one.ourwiki.requestdto.PostModifyRequestDto;
import com.one.ourwiki.responsedto.PostResponseDto;
import com.one.ourwiki.responsedto.PostDetailResponseDto;
import com.one.ourwiki.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    
    private final PostService postService;
    
    //글 작성 
    @PostMapping("/post")
    public ResponseEntity createPost(@RequestBody @Validated PostCreateRequestDto PostCreateRequestDto){
        return postService.createPost(PostCreateRequestDto);
    }

    //글 조회
    @GetMapping("/")
    public List<PostResponseDto> viewPosts() {
        return postService.viewPosts();
    }

    //글 수정
    @PostMapping("/post/{postid}")
    public ResponseEntity modifyPost(@PathVariable Long postid,@RequestBody PostModifyRequestDto postModifyRequestDto){
        return postService.modifyPost(postid,postModifyRequestDto);
    }

    // 글 삭제
    @DeleteMapping("/post/{postid}")
    public ResponseEntity deletePost(@PathVariable Long postid,@RequestBody PostDeleteRequestDto postDeleteRequestDto){
        return postService.delete(postid, postDeleteRequestDto);
    }

    //글 좋아요
    @PostMapping("/like/{postid}")
    public ResponseEntity like(@PathVariable Long postid, @RequestBody PostLikeRequestDto postLikeRequestDto){
        return postService.like(postid, postLikeRequestDto);
    }

    @GetMapping("/post/{postId}")
    public PostDetailResponseDto getDetailPost(@PathVariable Long postId) {
        return postService.getDetailPost(postId);
    }

}