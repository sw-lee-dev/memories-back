package com.lsw.memories_back.common.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.lsw.memories_back.common.entity.BoardEntity;

import lombok.Getter;

@Getter
public class GetBoardResponseDto extends ResponseDto {
  private Integer receptionNumber;
  private Boolean status;
  private String title;
  private String writerId;
  private String writeDatetime;
  private Integer viewCount;
  private String contents;
  private String comment;

  private GetBoardResponseDto(BoardEntity boardEntity) throws Exception {
    super();
    // String writeDatetime = ChangeDateFormatUtil.changeYYYYMMDD(boardEntity.getWriteDatetime());

    this.receptionNumber = boardEntity.getReceptionNumber();
    this.status = boardEntity.getStatus();
    this.title = boardEntity.getTitle();
    this.writerId = boardEntity.getWriterId();
    this.viewCount = boardEntity.getViewCount();
    this.contents = boardEntity.getContents();
    this.comment = boardEntity.getComment();
  }

  public static ResponseEntity<GetBoardResponseDto> success(BoardEntity boardEntity) throws Exception {
    GetBoardResponseDto responseBody = new GetBoardResponseDto(boardEntity);
    return ResponseEntity.status(HttpStatus.OK).body(responseBody);
  }
}
