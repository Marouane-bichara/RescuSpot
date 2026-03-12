package com.example.rescuespot.post.service.Impl;

import com.example.rescuespot.identity.entity.Account;
import com.example.rescuespot.identity.repository.IAccountRepository;
import com.example.rescuespot.post.DTO.request.PostRequestDTO;
import com.example.rescuespot.post.DTO.response.PostResponseDTO;
import com.example.rescuespot.post.entity.Post;
import com.example.rescuespot.post.mapper.IPostMapper;
import com.example.rescuespot.post.repository.IPostRepository;
import com.example.rescuespot.post.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

    private final IPostRepository postRepository;
    private final IAccountRepository accountRepository;
    private final IPostMapper postMapper;


    @Override
    public PostResponseDTO createPost(PostRequestDTO request) {

        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        Post post = postMapper.toEntity(request);

        post.setAccount(account);

        Post savedPost = postRepository.save(post);

        return postMapper.toDTO(savedPost);
    }


    @Override
    public void deletePost(Long postId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        postRepository.delete(post);
    }


    @Override
    public PostResponseDTO getPostById(Long postId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        return postMapper.toDTO(post);
    }


    @Override
    public List<PostResponseDTO> getAllPosts() {

        return postRepository.findAll()
                .stream()
                .map(postMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public List<PostResponseDTO> getPostsByAccount(Long accountId) {

        return postRepository.findAll()
                .stream()
                .filter(post -> post.getAccount().getIdAccount().equals(accountId))
                .map(postMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PostResponseDTO updatePost(Long postId, PostRequestDTO request) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.setContent(request.getContent());

        if (request.getImages() != null) {
            post.setImages(request.getImages());
        }

        Post updatedPost = postRepository.save(post);

        return postMapper.toDTO(updatedPost);
    }
}