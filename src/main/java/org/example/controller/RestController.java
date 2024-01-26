package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.ChatMessage;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {

    private final SimpMessageSendingOperations messagingTemplate;

    @PostMapping("/post")
    public void test(@RequestBody ChatMessage chatMessage) {
        messagingTemplate.convertAndSend("/topic/public", chatMessage);
    }
}
