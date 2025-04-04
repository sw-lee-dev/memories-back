package com.lsw.memories_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lsw.memories_back.common.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
  
  BoardEntity findByReceptionNumber(Integer receptionNumber);

}
