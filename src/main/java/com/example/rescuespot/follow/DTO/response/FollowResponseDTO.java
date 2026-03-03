package com.example.rescuespot.follow.DTO.response;

import com.example.rescuespot.follow.entity.enumFollow.FollowedType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowResponseDTO {

    private Long idFollow;

    private Long followerId;

    private Long followedId;

    private FollowedType followedType;

    private Date createdAt;
}