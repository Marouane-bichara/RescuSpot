package com.example.rescuespot.Message.mapper;

import com.example.rescuespot.Message.DTO.MessageResponseDTO;
import com.example.rescuespot.Message.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    @Mapping(source = "conversation.idConversation", target = "conversationId")

    @Mapping(source = "sender.idAccount", target = "senderId")
    @Mapping(source = "sender.username", target = "senderUsername")
    MessageResponseDTO toDTO(Message message);
}
