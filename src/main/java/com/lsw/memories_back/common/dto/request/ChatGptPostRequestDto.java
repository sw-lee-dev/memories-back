package com.lsw.memories_back.common.dto.request;

import java.util.List;

import com.lsw.memories_back.common.vo.ChatGptQuestionVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatGptPostRequestDto {
  private String model;
  private List<ChatGptQuestionVO> messages;
}
