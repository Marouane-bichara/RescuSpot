package com.example.rescuespot.post.service;

import com.example.rescuespot.post.DTO.request.PostRequestDTO;
import com.example.rescuespot.post.DTO.response.PostResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPostService {
    PostResponseDTO createPost(PostRequestDTO request);

    void deletePost(Long postId);

    PostResponseDTO getPostById(Long postId);

    List<PostResponseDTO> getAllPosts();

    List<PostResponseDTO> getPostsByAccount(Long accountId);

    PostResponseDTO updatePost(Long postId, PostRequestDTO request);
}
