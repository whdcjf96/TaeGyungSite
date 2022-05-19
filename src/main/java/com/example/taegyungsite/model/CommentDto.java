package com.example.taegyungsite.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * packageName : com.example.taegyungsite.model
 * fileName : CommentDto
 * author : jc
 * date : 2022-05-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-19         jc          최초 생성
 */
@Setter
@Getter
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CommentDto extends CommonDto{
//    댓글 번호
    private int idx;

//    게시판 번호
    private int boardIdx;

//    댓글내용
    private String content;

//    댓글 작성자
    private String writer;

//    삭제 여부 (y or n)
    private String deleteYn;

//    댓글 등록 일시
    private LocalDateTime insertDate;

    //    댓글 수정 일시
    private LocalDateTime updateDate;

    //    댓글 삭제 일시
    private LocalDateTime deleteDate;



}
