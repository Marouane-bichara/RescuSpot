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
public class ConversationResponseDTO {

    private Long idConversation;

    private Long senderId;
    private String senderUsername;

    private Long receiverId;
    private String receiverUsername;

    private ConversationType type;

    private String relatedEntityType;
}