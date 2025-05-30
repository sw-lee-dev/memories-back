package com.lsw.memories_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsw.memories_back.common.dto.request.openai.GetWayRequestDto;
import com.lsw.memories_back.common.dto.response.openai.GetWayReosponseDto;
import com.lsw.memories_back.service.OpenAIService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/open-ai")
@RequiredArgsConstructor
public class OpenAIController {
  
  private final OpenAIService openAIService;

  @PostMapping("/way")
  public ResponseEntity<? super GetWayReosponseDto> getWay(
    @RequestBody @Valid GetWayRequestDto requestBody,
    @AuthenticationPrincipal String userId
  ) {
    return openAIService.getWay(requestBody, userId);
  }

}
