package com.example.taegyungsite.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * packageName : com.example.taegyungsite.model
 * fileName : BoardDto
 * author : jc
 * date : 2022-05-17
 * description : 개발순서 : Model - Dao - xml - Service - controller
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-17         jc          최초 생성
 */
@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BoardDto extends CommonDto{
//    번호 (PK:기본키)
    private Long idx;
//    제목
    private String title;
//    내용
    private String content;
//    작성자
    private String writer;
//    조회수
    private int viewCnt;
//    공지여부(Y,N)
    private String noticeYn;
//    비밀여부(Y,N)
    private String secretYn;

}

