package com.example.rescuespot.follow.mapper;

import com.example.rescuespot.follow.DTO.response.FollowResponseDTO;
import com.example.rescuespot.follow.entity.Follow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IFollowMapper {

    @Mapping(source = "follower.idAccount", target = "followerId")
    @Mapping(source = "followed.idAccount", target = "followedId")
    FollowResponseDTO toDTO(Follow follow);

}