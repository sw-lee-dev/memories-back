package com.lsw.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.lsw.memories_back.common.dto.request.ChatGptPostRequestDto;
import com.lsw.memories_back.common.dto.response.ChatGptResultResponseDto;

public interface ChatGptService {
  ResponseEntity<? super ChatGptResultResponseDto> postChatGpt(ChatGptPostRequestDto dto);
}
