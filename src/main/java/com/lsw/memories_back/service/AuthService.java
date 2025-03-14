package com.lsw.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.lsw.memories_back.common.dto.request.auth.IdCheckRequestDto;
import com.lsw.memories_back.common.dto.request.auth.SignUpRequestDto;
import com.lsw.memories_back.common.dto.response.ResponseDto;

public interface AuthService {
  ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto);
  ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);
}
