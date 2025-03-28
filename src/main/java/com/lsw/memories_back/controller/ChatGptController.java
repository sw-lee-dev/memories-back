package com.lsw.memories_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsw.memories_back.common.dto.request.ChatGptPostRequestDto;
import com.lsw.memories_back.common.dto.response.ChatGptResultResponseDto;
import com.lsw.memories_back.service.ChatGptService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/openai")
@RequiredArgsConstructor
public class ChatGptController {
  
  private final ChatGptService chatGptService;

  @PostMapping("/chat")
  public ResponseEntity<? super ChatGptResultResponseDto> postChatGpt(
    @RequestBody @Valid ChatGptPostRequestDto requestBody
  ) {
    return chatGptService.postChatGpt(requestBody);
  }

}
