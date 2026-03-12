package com.example.rescuespot.post.controller;

import com.example.rescuespot.post.DTO.request.PostRequestDTO;
import com.example.rescuespot.post.DTO.response.PostResponseDTO;
import com.example.rescuespot.post.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final IPostService postService;


    @PostMapping
    public ResponseEntity<PostResponseDTO> createPost(
            @RequestBody PostRequestDTO request
    ) {

        return ResponseEntity.ok(postService.createPost(request));
    }


    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(
            @PathVariable Long postId
    ) {

        postService.deletePost(postId);

        return ResponseEntity.ok("Post deleted successfully");
    }


    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDTO> getPostById(
            @PathVariable Long postId
    ) {

        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> getAllPosts() {

        return ResponseEntity.ok(postService.getAllPosts());
    }


    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<PostResponseDTO>> getPostsByAccount(
            @PathVariable Long accountId
    ) {

        return ResponseEntity.ok(postService.getPostsByAccount(accountId));
    }


    @PutMapping("/{postId}")
    public ResponseEntity<PostResponseDTO> updatePost(
            @PathVariable Long postId,
            @RequestBody PostRequestDTO request
    ) {

        return ResponseEntity.ok(postService.updatePost(postId, request));
    }
}