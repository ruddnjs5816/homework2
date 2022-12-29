package com.example.homework1.service;

import com.example.homework1.dto.CreatePostRequest;
import com.example.homework1.dto.PostResponse;
import com.example.homework1.dto.UpdatePostRequest;
import com.example.homework1.entity.Post;
import com.example.homework1.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(CreatePostRequest createPostRequest){
        Post post = new Post(createPostRequest.getTitle(), createPostRequest.getUsername(),
                createPostRequest.getPassword() , createPostRequest.getContents());
        postRepository.save(post);
    }

    public PostResponse getPost(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시물 없음"));
        return new  PostResponse(post);
    }

    public List<PostResponse> getPostList(){
        List<Post> postList = postRepository.findAllByOrderByDateCreatedDesc();
        List<PostResponse> postResponseList = new ArrayList<>();
        for (Post post:postList) {
            postResponseList.add(new PostResponse(post));
        }
        return postResponseList;
    }

    public void updatePost(Long postId, UpdatePostRequest updatePostRequest){
        Post postSaved = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시물 없음"));

        if(postSaved.isValidPassword(updatePostRequest.getPassword())){
            postSaved.update(updatePostRequest.getTitle(), updatePostRequest.getUsername(), updatePostRequest.getContents());
            postRepository.save(postSaved);
        }else {
            throw new IllegalArgumentException("패스워드가 틀렸습니다");
        }
    }

    public void deletePost(Long postId, Long password){
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시물 없음"));
        if(post.isValidPassword(password)){
            postRepository.delete(post);
        }else {
            throw new RuntimeException("패스워드가 틀렸습니다");
        }
    }

}
