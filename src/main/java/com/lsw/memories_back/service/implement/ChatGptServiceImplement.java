package com.lsw.memories_back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.lsw.memories_back.common.dto.request.ChatGptPostRequestDto;
import com.lsw.memories_back.common.dto.response.ChatGptResponseDto;
import com.lsw.memories_back.common.dto.response.ChatGptResultResponseDto;
import com.lsw.memories_back.common.dto.response.ResponseDto;
import com.lsw.memories_back.common.vo.ChatGptQuestionVO;
import com.lsw.memories_back.service.ChatGptService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatGptServiceImplement implements ChatGptService {

  private final WebClient webClient;

  @Override
  public ResponseEntity<? super ChatGptResultResponseDto> postChatGpt(ChatGptPostRequestDto dto) {

    String content = "앤비디아에 대해서 알려주세요. 결과는 마크다운 언어로 보여주세요.";

    List<ChatGptQuestionVO> messages = List.of(new ChatGptQuestionVO("user", content));
    ChatGptPostRequestDto requestBody = new ChatGptPostRequestDto("gpt-4o", messages);

    String result = null;

    try {
      ChatGptResponseDto responseBody = webClient.post()
        .uri("/chat/completions")
        .bodyValue(requestBody)
        .retrieve()
        .bodyToMono(ChatGptResponseDto.class)
        .block();

      if (responseBody == null || responseBody.getQuestion() == null || responseBody.getQuestion().isEmpty()) return ResponseDto.openAIError();

      result = responseBody.getQuestion().get(0).getMessages().getMessages();

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.openAIError();
    }

    return ChatGptResultResponseDto.success(result);
  }
}
