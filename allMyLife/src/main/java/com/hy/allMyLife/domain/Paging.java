package com.hy.allMyLife.domain;

public class Paging {
	
	private int allDataCount;		// 전체 데이터 수
	private int datePerPage;		// 한 페이지에서 보여 줄 데이터 수
	private int pageCount;			// 한 화면에 보여질 페이지 그룹 수
	private int pageNum;			// 현재 페이지 번호
	private int startNum;			// 현재 페이지에 뿌려질 데이터 첫 번쨰 번호
	private int endNum;				// 현재 페이지에 뿌려질 데이터의 마지막 번호
	private int totalPage;			// 총 페이지 수
	private int pageGroup;			// 현재 페이지의 그룹 순서
	private int first;				// 현재 페이지 그룹의(현재 화면의) 첫 번쨰 페이지 번호
	private int last;				// 현재 페이지 그룹의(현재 화면의) 마지막 페이지 번호
	private int prev;				// 이전 페이지 그룹의 첫 번쨰 번호( < 클릭 시 )
	private int next;				// 다음 페이지 그룹의 첫 번쨰 번호( > 클릭 시 )
	
	public int getAllDataCount() {
		return allDataCount;
	}
	
	public void setAllDataCount(int allDataCount) {
		this.allDataCount = allDataCount;
	}
	
	public int getDatePerPage() {
		return datePerPage;
	}
	public void setDatePerPage(int datePerPage) {
		this.datePerPage = datePerPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageGroup() {
		return pageGroup;
	}
	public void setPageGroup(int pageGroup) {
		this.pageGroup = pageGroup;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
}
