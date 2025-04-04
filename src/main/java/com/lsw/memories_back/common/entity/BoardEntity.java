package com.lsw.memories_back.common.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {
  @Id
  private Integer receptionNumber;
  private Boolean status;
  private String title;
  private String writerId;
  private String writeDatetime;
  private Integer viewCount;
  private String contents;
  private String comment;
}
