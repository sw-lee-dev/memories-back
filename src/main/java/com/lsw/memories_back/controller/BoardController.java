package com.lsw.memories_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsw.memories_back.common.dto.response.GetBoardResponseDto;
import com.lsw.memories_back.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
  
  private final BoardService boardService;

  @GetMapping("/{receptionNumber}")

  public ResponseEntity<? super GetBoardResponseDto> getBoard (
    @PathVariable("receptionNumber") int receptionNumber
  ) {
    ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(receptionNumber);
    return response;
  }
}
