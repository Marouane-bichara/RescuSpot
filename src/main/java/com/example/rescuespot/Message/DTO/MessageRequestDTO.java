package com.example.rescuespot.Message.DTO;

import com.example.rescuespot.conversation.entity.ConversationEnums.ConversationType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequestDTO {

    private Long senderId;
    private Long receiverId;
    private String content;
    private ConversationType conversationType;
}