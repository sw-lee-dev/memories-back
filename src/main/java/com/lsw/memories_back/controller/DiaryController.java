package com.lsw.memories_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsw.memories_back.common.dto.request.diary.PostDiaryRequestDto;
import com.lsw.memories_back.common.dto.response.ResponseDto;
import com.lsw.memories_back.service.DiaryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/diary")
@RequiredArgsConstructor
public class DiaryController {
  
  private final DiaryService diaryService;

  @PostMapping({"", "/"})
  public ResponseEntity<ResponseDto> postDiary(
    @RequestBody @Valid PostDiaryRequestDto requestBody,
    @AuthenticationPrincipal String userId /*토큰에 있는 정보 가져오기*/
  ) {
    ResponseEntity<ResponseDto> response = diaryService.postDiary(requestBody, userId);
    return response;
  }

}
