package com.springboot.smartvalve.common;

import org.springframework.web.util.UriComponentsBuilder;
//TODO: 요구사항에 따라 내역 리스트 페이징처리 위함.
/**Criteria 클래스 :
 *   페이징 처리를 위해서 사용될 객체로 페이지 번호, 페이지당 출력할 게시글 수를
 *   관리할 객체를 생성
 * */
/*현 클래스는 차후 프로젝트 업그레이드를 하기 위한 클래스입니다.*/
public class Criteria {
    private int page; //현재 페이지를 나타내는 필드 변수
    private int perPageNum; //페이지당 표시할 게시글의 수

    //속성 searchType, keyword 추가
    //검색을 했을 때 검색 결과에 따른 정보를 게시물을 삭제, 등록, 수정, 조회 후에도
    //그대로 유지하려면 URI에 searchType, keyword를 달아야함.
    private String searchType; //검색 타입
    private String keyword; //검색어

    //최초 default 생성자로 기본 객체 생성시 초기값을 지정한다. (1페이지, 10개씩)
    public Criteria() {
        this.page = 1; //사용자가 세팅하지 않으면 기본 1
        this.perPageNum = 10; //페이지당 기본 10개씩 출력하도록 세팅
        this.searchType = null;
        this.keyword = null;

    }

    //pageStart를 반환
    /*
       1페이지일 때 -> 0 ~ 9 게시글
       2페이지일 때 -> 10~ 19
       limit구문에서 시작 부분에 필요한 값을 반환(mybatis에서 사용)
    */
    public int getPageStart() {
        return (this.page - 1) * perPageNum;
    }

    //getter setter
    public int getPage() {
        return page;
    }

    /* 페이지는 1페이지부터임으로 0보다 작거나 같은 값일 경우
      무조건 첫번째 페이지로 설정되도록 해준다. */
    public void setPage(int page) {
        if (page <= 0) {

            this.page = 1;
        } else {
            this.page = page;
        }
    }

    public int getPerPageNum() {
        return perPageNum;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setPerPageNum(int perPageNum) {
        if (perPageNum <= 0 || perPageNum > 100) {
            this.perPageNum = 10;
        } else {
            this.perPageNum = perPageNum;
        }
    }

    public String makeQuery() {
        UriComponentsBuilder uriComponentsBuilder =
                UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("perPageNum", this.perPageNum);

        /*사용자가 검색을 하지도 않았는데 굳이 searchType과 keyword를 가지고 갈 필요가 없기 때문에 조건을 줌*/
        if (searchType != null) {
            uriComponentsBuilder
                    .queryParam("searchType", this.searchType)
                    .queryParam("keyword", this.keyword);
        }
        return uriComponentsBuilder.build().encode().toString();
    }

    @Override
    public String toString() {
        return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", " +
                "searchType=" + searchType + ", keyword="
                + keyword + "]";
    }
}

/*
org.spring.framework.web.util.UriComponentsBuilder는 여러 개의 파라미터들을 연결하여
URL형태로 만들어주는 기능을 가지고 있습니다.
쿼리 문자열을 추가해줘서 원하는 URI를 만들 수 있다.
쿼리 문자열은 /~/~?page=3&perPageNum=10 처럼 URL에 ?뒤에 오는 것들을 말한다.

*/
