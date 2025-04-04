package com.lsw.memories_back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.lsw.memories_back.common.dto.request.openai.ChatRequestDto;
import com.lsw.memories_back.common.dto.request.openai.GetWayRequestDto;
import com.lsw.memories_back.common.dto.response.ResponseDto;
import com.lsw.memories_back.common.dto.response.openai.ChatResponseDto;
import com.lsw.memories_back.common.dto.response.openai.GetWayReosponseDto;
import com.lsw.memories_back.common.entity.UserEntity;
import com.lsw.memories_back.common.vo.GptMessageVO;
import com.lsw.memories_back.repository.UserRepository;
import com.lsw.memories_back.service.OpenAIService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OpenAIServiceImplement implements OpenAIService {

  private final WebClient webClient;
  private final UserRepository userRepository;

  @Override
  public ResponseEntity<? super GetWayReosponseDto> getWay(GetWayRequestDto dto, String userId) {

    UserEntity userEntity = null;

    try {
      userEntity = userRepository.findByUserId(userId);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    if (userEntity.getGender() == null || userEntity.getAge() == null) return ResponseDto.validationFail();

    String gender = userEntity.getGender().equals("man") ? "남성" : "여성";
    Integer age = userEntity.getAge();
    String type = dto.getType();

    String content = "대한민국 " + age + "세 " + gender + "이 " + type + "을 높일 수 있는 방법에 대해 알려주세요. 결과는 마크다운으로 작성해주세요." ;

    List<GptMessageVO> messages = List.of(new GptMessageVO("user", content));
    ChatRequestDto requestBody = new ChatRequestDto("gpt-4o-mini", messages);

    String result = null;

    try {
      ChatResponseDto responseBody = webClient.post()
        .uri("/chat/completions")
        .bodyValue(requestBody)
        .retrieve()
        .bodyToMono(ChatResponseDto.class)
        .block();

      if (responseBody == null || responseBody.getChoices() == null || responseBody.getChoices().isEmpty()) return ResponseDto.openAIError();

      result = responseBody.getChoices().get(0).getMessage().getContent();
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.openAIError();
    }

    return GetWayReosponseDto.success(result);
  }
  
}
