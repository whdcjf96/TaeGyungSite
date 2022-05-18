package com.example.taegyungsite.controller;

import com.example.taegyungsite.model.BoardDto;
import com.example.taegyungsite.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.example.taegyungsite.controller
 * fileName : BoardApiController
 * author : jc
 * date : 2022-05-18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18         jc          최초 생성
 */
@RestController
@RequestMapping("/api")
public class BoardApiController {

    @Autowired
    BoardServiceImpl boardService;

    @GetMapping("/board/write/{idx}")
    public BoardDto openBoardWrite(@PathVariable("idx") Long idx){
//        상세 목록 보기 서비스를 호출(select : 1건)
        BoardDto detail = boardService.getBoardDetail(idx);
        return detail;
    }

    @PostMapping("/board/register")
    public List<BoardDto> registerBoard(@RequestBody BoardDto boardDto){
        try{
            System.out.println("컨트롤러쪽 보드 : "+ boardDto);
            boolean isRegistered = boardService.registerBoard(boardDto);
        }catch (DataAccessException e){
//            DB관련된 에러는 여기로 들어옴
//            TODO => DB처리 과정에 문제가 발생했다는 메세지를 출력
        }catch (Exception e){
//            DB 외의 에러일 경우 여기로 들어옴
//            TODO => 시스템에 문제가 발생했다는 메세지를 출력
        }
        return boardService.getBoardAllList();
    }

//    update문
    @PutMapping(value = "/board/delete/{idx}")
    public List<BoardDto> deleteBoard(@PathVariable("idx") Long idx){
        boolean isDeleted = boardService.deleteBoard(idx);
        return boardService.getBoardAllList();
    }
//    페이징 처리를 위한 게시물 검색 메뉴
    @GetMapping("/board/list/cur-page-no/{currentPageNo}/records-per-page/{recordsPerPage}")
    public List<BoardDto> openBoardList(BoardDto params){

        return boardService.getBoardList(params);
    }
}
