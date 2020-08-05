package com.springboot.smartvalve.common;

import org.springframework.web.util.UriComponentsBuilder;

/*Criteria 클래스 :
*   페이징 처리를 위해서 사용될 객체로 페이지 번호, 페이지당 출력할 게시글 수를
*   관리할 객체를 생성
* */
public class Criteria {
    private int page; //현재 페이지를 나타내는 필드 변수
    private int perPageNum; //페이지당 표시할 게시글의 수

    //속성 searchType, keyword 추가
    private String searchType;
    private String keyword;

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
        return (this.page - 1)*perPageNum;
    }

    //getter setter
    public int getPage() {
        return page;
    }

    /* 페이지는 1페이지부터임으로 0보다 작거나 같은 값일 경우
      무조건 첫번째 페이지로 설정되도록 해준다. */
    public void setPage(int page) {
        if(page <= 0) {

            this.page = 1;
        }else {
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
        if(perPageNum <=0 || perPageNum > 100) {
            this.perPageNum = 10;
        }else {
            this.perPageNum = perPageNum;
        }
    }

    public String makeQuery() {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("perPageNum", this.perPageNum);

        if (searchType!=null) {
            uriComponentsBuilder
                    .queryParam("searchType", this.searchType)
                    .queryParam("keyword", this.keyword);
        }
        return uriComponentsBuilder.build().encode().toString();
    }

    @Override
    public String toString() {
        return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", searchType=" + searchType + ", keyword="
                + keyword + "]";
    }
}