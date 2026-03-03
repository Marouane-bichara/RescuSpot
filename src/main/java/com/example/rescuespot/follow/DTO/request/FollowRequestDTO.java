package com.example.rescuespot.follow.DTO.request;

import com.example.rescuespot.follow.entity.enumFollow.FollowedType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowRequestDTO {

    private Long followerId;

    private Long followedId;

    private FollowedType followedType;
}