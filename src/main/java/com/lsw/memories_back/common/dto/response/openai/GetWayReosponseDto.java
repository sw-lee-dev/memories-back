package com.lsw.memories_back.common.dto.response.openai;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.lsw.memories_back.common.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class GetWayReosponseDto extends ResponseDto {
  private String result;

  private GetWayReosponseDto(String result) {
    this.result = result;
  }

  public static ResponseEntity<GetWayReosponseDto> success(String result) {
    GetWayReosponseDto body = new GetWayReosponseDto(result);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }
}
