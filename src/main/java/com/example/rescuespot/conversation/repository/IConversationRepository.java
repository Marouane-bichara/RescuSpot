package com.example.rescuespot.conversation.repository;

import com.example.rescuespot.conversation.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IConversationRepository extends JpaRepository<Conversation, Long> {

    Optional<Conversation> findBySender_IdAccountAndReceiver_IdAccount(
            Long senderId,
            Long receiverId
    );

    @Query("""
SELECT c FROM Conversation c
WHERE (c.sender.idAccount = :senderId AND c.receiver.idAccount = :receiverId)
   OR (c.sender.idAccount = :receiverId AND c.receiver.idAccount = :senderId)
""")
    Optional<Conversation> findConversationBetweenUsers(Long senderId, Long receiverId);

    @Query("SELECT c FROM Conversation c WHERE c.sender.idAccount = :userId OR c.receiver.idAccount = :userId")
    List<Conversation> findAllByUserId(@Param("userId") Long userId);

    List<Conversation> findAllBySender_IdAccountOrReceiver_IdAccount(Long userId, Long userId1);
}