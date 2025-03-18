package com.lsw.memories_back.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lsw.memories_back.common.dto.request.diary.PostDiaryRequestDto;
import com.lsw.memories_back.common.dto.response.ResponseDto;
import com.lsw.memories_back.common.entity.DiaryEntity;
import com.lsw.memories_back.repository.DiaryRepository;
import com.lsw.memories_back.service.DiaryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiaryServiceImplement implements DiaryService {

  private final DiaryRepository diaryRepository;

  @Override
  public ResponseEntity<ResponseDto> postDiary(PostDiaryRequestDto dto, String userId) {
    
    try {

      DiaryEntity diaryEntity = new DiaryEntity(dto, userId);
      diaryRepository.save(diaryEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.CREATED);
  }
  
}
