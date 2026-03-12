package com.example.rescuespot.follow.service;

import com.example.rescuespot.follow.DTO.request.FollowRequestDTO;
import com.example.rescuespot.follow.DTO.response.FollowResponseDTO;

import java.util.List;

public interface IFollowService {

    FollowResponseDTO follow(FollowRequestDTO request);

    void unfollow(Long followerId, Long followedId);

    List<FollowResponseDTO> getFollowers(Long accountId);

    List<FollowResponseDTO> getFollowing(Long accountId);
}