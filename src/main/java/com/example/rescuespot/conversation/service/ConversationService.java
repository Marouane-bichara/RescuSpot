package com.example.rescuespot.conversation.service;

import com.example.rescuespot.conversation.DTO.ConversationRequestDTO;
import com.example.rescuespot.conversation.DTO.ConversationResponseDTO;
import com.example.rescuespot.conversation.entity.Conversation;
import com.example.rescuespot.conversation.mapper.ConversationMapper;
import com.example.rescuespot.conversation.repository.IConversationRepository;
import com.example.rescuespot.identity.entity.Account;
import com.example.rescuespot.identity.repository.IAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConversationService {

    private final IConversationRepository conversationRepository;
    private final IAccountRepository accountRepository;
    private final ConversationMapper conversationMapper;

    public ConversationResponseDTO createConversation(ConversationRequestDTO dto) {

        Account sender = accountRepository.findById(dto.getSenderId())
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        Account receiver = accountRepository.findById(dto.getReceiverId())
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        Conversation conversation = new Conversation();

        conversation.setSender(sender);
        conversation.setReceiver(receiver);
        conversation.setType(dto.getType());
        conversation.setRelatedEntityType(dto.getRelatedEntityType());

        conversationRepository.save(conversation);

        return conversationMapper.toDTO(conversation);
    }

}
