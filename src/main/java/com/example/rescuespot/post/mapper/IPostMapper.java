package com.example.rescuespot.post.mapper;

import com.example.rescuespot.comment.mapper.ICommentMapper;
import com.example.rescuespot.identity.mapper.IAccountMapper;
import com.example.rescuespot.like.mapper.ILikeMapper;
import com.example.rescuespot.post.DTO.request.PostRequestDTO;
import com.example.rescuespot.post.DTO.response.PostResponseDTO;
import com.example.rescuespot.post.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;


@Mapper(componentModel = "spring", uses = { IAccountMapper.class })
public interface IPostMapper {

    @Mapping(target = "account.idAccount", source = "accountId")
    Post toEntity(PostRequestDTO dto);

    @Mapping(target = "likesCount", source = "likes", qualifiedByName = "countList")
    @Mapping(target = "commentsCount", source = "comments", qualifiedByName = "countList")
    PostResponseDTO toDTO(Post post);

    @Named("countList")
    default int countList(List<?> list) {
        return list != null ? list.size() : 0;
    }
}
