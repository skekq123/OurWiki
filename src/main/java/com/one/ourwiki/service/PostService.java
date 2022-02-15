package com.one.ourwiki.service;

import com.one.ourwiki.domain.Comment;
import com.one.ourwiki.domain.Contributor;
import com.one.ourwiki.domain.Post;
import com.one.ourwiki.repository.CommentRepository;
import com.one.ourwiki.repository.PostRepository;
import com.one.ourwiki.requestdto.PostCreateRequestDto;
import com.one.ourwiki.requestdto.PostDeleteRequestDto;
import com.one.ourwiki.requestdto.PostLikeRequestDto;
import com.one.ourwiki.requestdto.PostModifyRequestDto;
import com.one.ourwiki.responsedto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;    

    public ResponseEntity createPost(PostCreateRequestDto PostCreateRequestDto) {
        
        //validation 로직을 통과하지 못하면

        //validation 로직을 통과하면
        Post post = new Post(PostCreateRequestDto);
        postRepository.save(post);
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

    // 게시글 전체 조회
    public List<PostResponseDto> viewPosts() {
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        List<Post> posts = postRepository.findAllByOrderByLikesDescModifiedAtDesc();

        Post[] postList = new Post[posts.size()];
        for (Post post : posts) {
            List<Comment> comments = commentRepository.findAllByPostId(post.getId());
            int commentCount = comments.size();
            PostResponseDto postResponseDto = new PostResponseDto(post, commentCount);
            postResponseDtos.add(postResponseDto);
        }
        return postResponseDtos;
    }

    public ResponseEntity modifyPost(Long postId, PostModifyRequestDto postModifyRequestDto) {


        //validation 로직을 통과하지 못하면


        //validation 로직을 통과하면
        Optional<Post> findPost = postRepository.findById(postId);
        if(findPost.isPresent()){
            Contributor newContributor = new Contributor(postModifyRequestDto.getContributor());
            findPost.get().modify(postModifyRequestDto.getDesc(), newContributor);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    public ResponseEntity delete(Long postid, PostDeleteRequestDto postDeleteRequestDto) {
        //validation 로직을 통과하지 못하면


        //validation 로직을 통과하면
        Optional<Post> findPost = postRepository.findById(postid);
        if(findPost.isPresent()){
            if(findPost.get().getPassword().equals(postDeleteRequestDto.getPassword())) {
                postRepository.deleteById(postid);
                return ResponseEntity.status(HttpStatus.OK).body(null);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

    public ResponseEntity like(Long postid, PostLikeRequestDto postLikeRequestDto) {

        //validation 로직을 통과하지 못하면


        //validation 로직을 통과하면
        Optional<Post> findPost = postRepository.findById(postid);
        if(findPost.isPresent()){
            findPost.get().like(postLikeRequestDto.getLike_value());
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
}
