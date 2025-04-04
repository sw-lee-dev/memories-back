package com.lsw.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.lsw.memories_back.common.dto.response.GetBoardResponseDto;

public interface BoardService {
  ResponseEntity<? super GetBoardResponseDto> getBoard(int receptionNumber);
}
