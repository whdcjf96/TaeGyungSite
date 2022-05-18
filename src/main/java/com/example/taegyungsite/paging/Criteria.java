package com.example.taegyungsite.paging;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * packageName : com.example.taegyungsite.paging
 * fileName : Criteria
 * author : jc
 * date : 2022-05-18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18         jc          최초 생성
 */
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Criteria {

//    현재 페이지 번호
    private int currentPageNo;

//    페이지당 출력할 데이터 개수
//    ex)1page 당 10건
    private int recordPerPage;

//    화면 하단에 출력할 페이지 사이즈
//    ex) <<1,2,3,4,5,6,7,8,9>>
    private int pageSize;

//    검색 키워드
    private String searchKeyword;

//    검색 유형
    private String searchType;

//    기본 생성자 : 페이지 초기화
    public Criteria(){
        this.currentPageNo=1; // 현재 페이지 1
        this.recordPerPage=10; // 1페이지 당 10건
        this.pageSize = 10; // 총페이지 10
    }

//    프론트 엔드단에서 쿼리스트링을 만들어서 날려주는 메소드
//    쿼리스트링(Query String) :
//    전통 ex) http://localhost:8080/board?currentPageNo=5&recordsPerPage=10
//    Rest API ex) http://localhost:8080/board/currentPageNo/5/recordsPerPage/10
    public String makeQueryString(int pageNo){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("currentPageNo", pageNo)
                .queryParam("recordsPerPage", recordPerPage)
                .queryParam("pageSize", pageSize)
                .queryParam("searchType", searchType)
                .queryParam("searchKeyword", searchKeyword)
                .build()
                .encode();
        return uriComponents.toUriString();
    }
}
