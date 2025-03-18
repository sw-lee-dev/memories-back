package com.lsw.memories_back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsw.memories_back.service.DiaryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/diary")
@RequiredArgsConstructor
public class DiaryController {
  
  private final DiaryService diaryService;

}
