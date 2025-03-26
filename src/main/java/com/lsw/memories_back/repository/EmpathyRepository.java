package com.lsw.memories_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lsw.memories_back.common.entity.EmpathyEntity;
import com.lsw.memories_back.common.entity.pk.EmpathyPK;

@Repository
public interface EmpathyRepository extends JpaRepository<EmpathyEntity, EmpathyPK> {
  
}
