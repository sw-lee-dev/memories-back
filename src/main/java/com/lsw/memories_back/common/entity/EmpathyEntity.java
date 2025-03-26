package com.lsw.memories_back.common.entity;

import com.lsw.memories_back.common.entity.pk.EmpathyPK;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "empathy")
@Table(name = "empathy")
@IdClass(EmpathyPK.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpathyEntity {
  @Id
  private String userId;
  @Id
  private Integer diaryNumber;
}
