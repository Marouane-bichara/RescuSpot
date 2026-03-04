package com.example.rescuespot.like.mapper;


import com.example.rescuespot.identity.mapper.IAccountMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = { IAccountMapper.class }
)
public interface ILikeMapper {
//    @Mapping(source = "post.idPost", target = "postId")
//    LikeResponseDTO toResponse(Like like);
//
//    @Mapping(source = "postId", target = "post.idPost")
//    Like toEntity(LikeRequestDTO dto);
}
