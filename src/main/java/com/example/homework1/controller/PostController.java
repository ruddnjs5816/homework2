package com.example.homework1.controller;

import com.example.homework1.dto.CreatePostRequest;
import com.example.homework1.dto.PostResponse;
import com.example.homework1.dto.UpdatePostRequest;
import com.example.homework1.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    //게시물 생성 api
    @PostMapping("/posts")
    public void createPost(@RequestBody CreatePostRequest createPostRequest) {
        postService.createPost(createPostRequest);
    }

    @GetMapping("/posts/{postId}")
    public PostResponse getPost(@PathVariable Long postId){
        return postService.getPost(postId);
    }

    @GetMapping("/posts")
    public List<PostResponse> getPostList(){
        return postService.getPostList();
    }

    @PutMapping("/posts/{postId}")
    public void updatePost(@PathVariable Long postId, @RequestBody UpdatePostRequest updatePostRequest){
        postService.updatePost(postId, updatePostRequest);
    }

    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable Long postId, @RequestParam Long password){
        postService.deletePost(postId,password);
    }

}
