package com.lsw.memories_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lsw.memories_back.common.dto.response.GetBoardResponseDto;
import com.lsw.memories_back.common.dto.response.ResponseDto;
import com.lsw.memories_back.common.entity.BoardEntity;
import com.lsw.memories_back.repository.BoardRepository;
import com.lsw.memories_back.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {

  private final BoardRepository boardRepository;

  @Override
  public ResponseEntity<? super GetBoardResponseDto> getBoard(int receptionNumber) {
    try {
      BoardEntity boardEntity = boardRepository.findByReceptionNumber(receptionNumber);
      if (boardEntity == null) return ResponseDto.noExistBoard();
      return GetBoardResponseDto.success(boardEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
  }
}
