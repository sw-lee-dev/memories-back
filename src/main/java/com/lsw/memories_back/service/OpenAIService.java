package com.lsw.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.lsw.memories_back.common.dto.request.openai.GetWayRequestDto;
import com.lsw.memories_back.common.dto.response.openai.GetWayReosponseDto;

public interface OpenAIService {
  ResponseEntity<? super GetWayReosponseDto> getWay(GetWayRequestDto dto, String userId);
}
