package com.example.rescuespot.conversation.DTO;

import com.example.rescuespot.conversation.entity.ConversationEnums.ConversationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConversationRequestDTO {

    private Long senderId;
    private Long receiverId;
    private ConversationType type;
    private String relatedEntityType;
}