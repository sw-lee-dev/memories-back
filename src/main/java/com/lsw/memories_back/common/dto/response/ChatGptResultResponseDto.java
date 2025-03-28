package com.lsw.memories_back.common.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;

@Getter
public class ChatGptResultResponseDto extends ResponseDto {
  private String result;

  private ChatGptResultResponseDto(String result) {
    this.result = result;
  }

  public static ResponseEntity<ChatGptResultResponseDto> success(String result) {
    ChatGptResultResponseDto body = new ChatGptResultResponseDto(result);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }
}
