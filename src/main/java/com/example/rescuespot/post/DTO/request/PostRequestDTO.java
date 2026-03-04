package com.example.rescuespot.post.DTO.request;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostRequestDTO {
    private String content;

    private List<String> images;

    private Long accountId;
}
