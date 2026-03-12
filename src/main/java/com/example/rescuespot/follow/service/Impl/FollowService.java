package com.example.rescuespot.follow.service.Impl;

import com.example.rescuespot.follow.DTO.request.FollowRequestDTO;
import com.example.rescuespot.follow.DTO.response.FollowResponseDTO;
import com.example.rescuespot.follow.entity.Follow;
import com.example.rescuespot.follow.mapper.IFollowMapper;
import com.example.rescuespot.follow.repository.IFollowRepository;
import com.example.rescuespot.follow.service.IFollowService;
import com.example.rescuespot.identity.entity.Account;
import com.example.rescuespot.identity.repository.IAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FollowService implements IFollowService {

    private final IFollowRepository followRepository;
    private final IAccountRepository accountRepository;
    private final IFollowMapper followMapper;


    public FollowResponseDTO follow(FollowRequestDTO request) {

        Account follower = accountRepository.findById(request.getFollowerId())
                .orElseThrow(() -> new RuntimeException("Follower not found"));

        Account followed = accountRepository.findById(request.getFollowedId())
                .orElseThrow(() -> new RuntimeException("Followed account not found"));

        Follow follow = new Follow();

        follow.setFollower(follower);
        follow.setFollowed(followed);
        follow.setFollowedType(request.getFollowedType());

        Follow savedFollow = followRepository.save(follow);

        return followMapper.toDTO(savedFollow);
    }

    public void unfollow(Long followerId, Long followedId) {

        Follow follow = followRepository.findAll()
                .stream()
                .filter(f -> f.getFollower().getIdAccount().equals(followerId)
                        && f.getFollowed().getIdAccount().equals(followedId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Follow relation not found"));

        followRepository.delete(follow);
    }


    public List<FollowResponseDTO> getFollowers(Long accountId) {

        return followRepository.findAll()
                .stream()
                .filter(f -> f.getFollowed().getIdAccount().equals(accountId))
                .map(followMapper::toDTO)
                .collect(Collectors.toList());
    }


    public List<FollowResponseDTO> getFollowing(Long accountId) {

        return followRepository.findAll()
                .stream()
                .filter(f -> f.getFollower().getIdAccount().equals(accountId))
                .map(followMapper::toDTO)
                .collect(Collectors.toList());
    }
}