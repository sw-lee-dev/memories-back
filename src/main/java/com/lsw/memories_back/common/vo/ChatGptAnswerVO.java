package com.lsw.memories_back.common.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatGptAnswerVO {
  private int index;
  private ChatGptQuestionVO messages;
  private String finish_reason;
}
