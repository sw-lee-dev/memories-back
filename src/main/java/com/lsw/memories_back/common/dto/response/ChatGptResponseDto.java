package com.lsw.memories_back.common.dto.response;

import java.util.List;

import com.lsw.memories_back.common.vo.ChatGptAnswerVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatGptResponseDto {
  private List<ChatGptAnswerVO> question;
}
