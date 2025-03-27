package com.lsw.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.lsw.memories_back.common.dto.request.diary.PatchDiaryRequestDto;
import com.lsw.memories_back.common.dto.request.diary.PostDiaryRequestDto;
import com.lsw.memories_back.common.dto.request.diary.PostCommentRequestDto;
import com.lsw.memories_back.common.dto.response.ResponseDto;
import com.lsw.memories_back.common.dto.response.diary.GetCommentResponseDto;
import com.lsw.memories_back.common.dto.response.diary.GetDiaryResponseDto;
import com.lsw.memories_back.common.dto.response.diary.GetEmpathyResponseDto;
import com.lsw.memories_back.common.dto.response.diary.GetMyDiaryResponseDto;

public interface DiaryService {
  ResponseEntity<ResponseDto> postDiary(PostDiaryRequestDto dto, String userId);
  ResponseEntity<? super GetMyDiaryResponseDto> getMyDiary(String userId);
  ResponseEntity<? super GetDiaryResponseDto> getDiary(Integer diaryNumber);
  ResponseEntity<ResponseDto> patchDiary(PatchDiaryRequestDto dto, Integer diaryNumber, String userId);
  ResponseEntity<ResponseDto> deleteDiary(Integer diaryNumber, String userId);

  ResponseEntity<? super GetEmpathyResponseDto> getEmpathy(Integer diaryNumber);
  ResponseEntity<ResponseDto> putEmpathy(Integer diaryNumber, String userId);

  ResponseEntity<? super GetCommentResponseDto> getComment(Integer diaryNumber);
  ResponseEntity<ResponseDto> postComment(PostCommentRequestDto dto, Integer diaryNumber, String userId);
}
