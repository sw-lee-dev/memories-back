package com.lsw.memories_back.common.dto.response.test;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.lsw.memories_back.common.dto.response.ResponseDto;
import com.lsw.memories_back.common.entity.ConcentrationTestEntity;
import com.lsw.memories_back.common.vo.ConcentrationTestVO;

import lombok.Getter;

@Getter
public class GetRecentlyConcentrationResponeDto extends ResponseDto {
  
  private List<ConcentrationTestVO> concentrationTests;

  private GetRecentlyConcentrationResponeDto(List<ConcentrationTestEntity> concentrationTestEntities) {
    this.concentrationTests = ConcentrationTestVO.getList(concentrationTestEntities);
  }

  public static ResponseEntity<GetRecentlyConcentrationResponeDto> success(List<ConcentrationTestEntity> concentrationTestEntities) {
    GetRecentlyConcentrationResponeDto body = new GetRecentlyConcentrationResponeDto(concentrationTestEntities);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }

}
