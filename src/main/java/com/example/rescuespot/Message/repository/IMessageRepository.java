package com.example.rescuespot.Message.repository;

import com.example.rescuespot.Message.entity.Message;
import com.example.rescuespot.conversation.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IMessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByConversation_IdConversationOrderBySentAtAsc(Long conversationId);

}
