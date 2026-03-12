package com.example.rescuespot.follow.controller;

import com.example.rescuespot.follow.DTO.request.FollowRequestDTO;
import com.example.rescuespot.follow.DTO.response.FollowResponseDTO;
import com.example.rescuespot.follow.service.IFollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follows")
@RequiredArgsConstructor
public class FollowController {

    private final IFollowService followService;


    @PostMapping
    public ResponseEntity<FollowResponseDTO> follow(
            @RequestBody FollowRequestDTO request
    ) {

        return ResponseEntity.ok(followService.follow(request));
    }


    @DeleteMapping
    public ResponseEntity<String> unfollow(
            @RequestParam Long followerId,
            @RequestParam Long followedId
    ) {

        followService.unfollow(followerId, followedId);

        return ResponseEntity.ok("Unfollowed successfully");
    }


    @GetMapping("/followers/{accountId}")
    public ResponseEntity<List<FollowResponseDTO>> getFollowers(
            @PathVariable Long accountId
    ) {

        return ResponseEntity.ok(followService.getFollowers(accountId));
    }


    @GetMapping("/following/{accountId}")
    public ResponseEntity<List<FollowResponseDTO>> getFollowing(
            @PathVariable Long accountId
    ) {

        return ResponseEntity.ok(followService.getFollowing(accountId));
    }
}