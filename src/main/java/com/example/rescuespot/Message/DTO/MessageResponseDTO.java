package com.example.rescuespot.Message.DTO;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponseDTO {

    private Long idMessage;
    private Long conversationId;
    private Long senderId;
    private String senderUsername;
    private String content;
    private Date sentAt;
}