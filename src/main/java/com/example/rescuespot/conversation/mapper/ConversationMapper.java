package com.example.rescuespot.conversation.mapper;

import com.example.rescuespot.conversation.DTO.ConversationResponseDTO;
import com.example.rescuespot.conversation.entity.Conversation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface ConversationMapper {
    @Mapping(source = "sender.idAccount", target = "senderId")
    @Mapping(source = "sender.username", target = "senderUsername")

    @Mapping(source = "receiver.idAccount", target = "receiverId")
    @Mapping(source = "receiver.username", target = "receiverUsername")
    ConversationResponseDTO toDTO(Conversation conversation);
}
