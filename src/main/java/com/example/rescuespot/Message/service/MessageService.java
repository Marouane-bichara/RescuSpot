package com.example.rescuespot.Message.service;

import com.example.rescuespot.Message.DTO.MessageRequestDTO;
import com.example.rescuespot.Message.DTO.MessageResponseDTO;
import com.example.rescuespot.Message.entity.Message;
import com.example.rescuespot.Message.mapper.MessageMapper;
import com.example.rescuespot.Message.repository.IMessageRepository;
import com.example.rescuespot.conversation.entity.Conversation;
import com.example.rescuespot.conversation.entity.ConversationEnums.ConversationType;
import com.example.rescuespot.conversation.repository.IConversationRepository;
import com.example.rescuespot.identity.entity.Account;
import com.example.rescuespot.identity.repository.IAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final IMessageRepository messageRepository;
    private final IConversationRepository conversationRepository;
    private final IAccountRepository accountRepository;
    private final MessageMapper messageMapper;

    public MessageResponseDTO sendMessage(MessageRequestDTO dto) {

        Account sender = accountRepository.findById(dto.getSenderId())
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        Account receiver = accountRepository.findById(dto.getReceiverId())
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        Conversation conversation = conversationRepository
                .findConversationBetweenUsers(sender.getIdAccount(), receiver.getIdAccount())
                .orElseGet(() -> {

                    Conversation newConversation = new Conversation();
                    newConversation.setSender(sender);
                    newConversation.setReceiver(receiver);
                    newConversation.setType(dto.getConversationType());

                    return conversationRepository.save(newConversation);
                });

        Message message = new Message();

        message.setConversation(conversation);
        message.setSender(sender);
        message.setContent(dto.getContent());
        message.setSentAt(new Date());

        messageRepository.save(message);

        return messageMapper.toDTO(message);
    }

    public List<MessageResponseDTO> getConversationMessages(Long conversationId) {

        return messageRepository
                .findByConversation_IdConversationOrderBySentAtAsc(conversationId)
                .stream()
                .map(messageMapper::toDTO)
                .collect(Collectors.toList());
    }
}
