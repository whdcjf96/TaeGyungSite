package com.example.taegyungsite.service;

import com.example.taegyungsite.model.BoardDto;

import java.util.List;

/**
 * packageName : com.example.taegyungsite.service
 * fileName : BoardService
 * author : jc
 * date : 2022-05-18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18         jc          최초 생성
 */
public interface BoardService {
//    게시판에 insert하는 서비스
    boolean registerBoard(BoardDto params);

//    상세 목록을 확인하는 서비스 (Select) 1건
    BoardDto getBoardDetail(Long inx);

//    일반 글 목록을 확인하는 서비스(Select) 전체 건수
    public List<BoardDto> getBoardAllList();

//    페이징 처리를 위한 서비스
    public List<BoardDto> getBoardList(BoardDto params);

//    게시판 글을 삭제하는 서비스 (update) : delete_Yn = 'Y' 수정
    public boolean deleteBoard(Long inx);

//

}
