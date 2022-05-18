package com.example.taegyungsite.service;

import com.example.taegyungsite.dao.BoardDao;
import com.example.taegyungsite.model.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * packageName : com.example.taegyungsite.service
 * fileName : BoardServiceImpl
 * author : jc
 * date : 2022-05-18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18         jc          최초 생성
 */
@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardDao boardDao;


    @Override
    public BoardDto getBoardDetail(Long idx) {
//      글 목록에 해당하는 상세 목록 보기 (select문 실행 : 1건)
        BoardDto boardDto = boardDao.selectBoardDetail(idx);
        return boardDto;

    }

//    게시판에 글 번호가 없으면 insert문 실행
//    글 번호가 있으면 update문 실행
    @Override
    public boolean registerBoard(BoardDto params) {
        //    insert 또는 update 결과를 저장하는 변수
//        위의 sql문이 정상수행되면 1 아니면 다른 값
        int queryResult=0;
        System.out.println("서비스쪽 보드"+params);
        if (params.getIdx() == null)
        {
//            새글 쓰기 insert
            queryResult = boardDao.insertBoard(params);
        }else{
//            상세 목록에서 글 수정 (update 문 실행)
            queryResult = boardDao.updateBoard(params);
        }
        return (queryResult == 1)? true:false;
    }

//    전체 게시물 select 하는 서비스
    @Override
    public List<BoardDto> getBoardAllList() {
        List<BoardDto> boardList = Collections.emptyList();
        boardList = boardDao.selectBoardAllList();

        return boardList;
    }


//    게시판 페이징 처리를 위한 서비스 구현
    @Override
    public List<BoardDto> getBoardList(BoardDto params) {
        List<BoardDto> boardDto = Collections.emptyList();

//        DB params에 해당하는 데이터가 있는지 먼저 확인인
        int boardTotalCount = boardDao.selectBoardTotalCount(params);

        if(boardTotalCount>0){
//            페이징 처리 서비스 호출
            boardDto = boardDao.selectBoardList(params);
        }
        return boardDto;

    }

    //    게시판 번호를 받아서 게시물을 삭제하는 서비스
    @Override
    public boolean deleteBoard(Long idx) {
        int queryResult =0;
        BoardDto board = boardDao.selectBoardDetail(idx);
//        Delete_Yn : N일때만 삭제를 진행 + board != null 아닐때
        if (board!=null && "N".equals(board.getDeleteYn())){
//            게시물 삭제 서비스(하지만 내부적으로 진짜 삭제는 x)
            queryResult = boardDao.deleteBoard(idx);
        }

        return (queryResult==1)? true : false;
    }
}
