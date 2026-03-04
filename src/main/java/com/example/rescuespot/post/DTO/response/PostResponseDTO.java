package com.example.rescuespot.post.DTO.response;

import com.example.rescuespot.identity.DTO.response.AccountResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDTO {
    private Long idPost;

    private String content;

    private List<String> images;

    private Date createdAt;

    private AccountResponseDTO account;

    private int likesCount;

    private int commentsCount;
}
