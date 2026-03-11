package com.example.rescuespot.Message.controller;


import com.example.rescuespot.Message.DTO.MessageRequestDTO;
import com.example.rescuespot.Message.DTO.MessageResponseDTO;
import com.example.rescuespot.Message.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageRestController {

    private final MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<MessageResponseDTO> sendMessage(@RequestBody MessageRequestDTO requestDTO) {

        MessageResponseDTO response = messageService.sendMessage(requestDTO);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/conversation/{conversationId}")
    public ResponseEntity<List<MessageResponseDTO>> getConversationMessages(
            @PathVariable Long conversationId) {

        List<MessageResponseDTO> messages =
                messageService.getConversationMessages(conversationId);

        return ResponseEntity.ok(messages);
    }
}