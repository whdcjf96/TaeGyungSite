package com.example.taegyungsite.dao;

import com.example.taegyungsite.model.CommentDto;

/**
 * packageName : com.example.taegyungsite.dao
 * fileName : CommentDao
 * author : jc
 * date : 2022-05-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-19         jc          최초 생성
 */
public interface CommentDao {
//    모든 댓글 조회
    CommentDto selectAllComment();

//    번호에 해당하는 댓글 조회
    CommentDto selectCommentByIdx(int idx);

//    댓글 작성
    void registerComment(CommentDto params);

//    댓글 수정
    void updateComment(CommentDto params);

//    댓글 삭제
    void deleteComment(int idx);


}
