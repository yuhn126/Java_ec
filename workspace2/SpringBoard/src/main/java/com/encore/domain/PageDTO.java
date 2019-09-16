package com.encore.domain;

public class PageDTO {
	// list.jsp페이지에서 출력되는 데이터를 표현, 제한[하단의 숫자 출력, 현재 페이지]를 저장하는 용도
	private int startPage; // 시작 페이지 : 예) 1.....10 보일때 1
							// 31 32 보일때 31
	private int endPage; // 끝 페이지 : 예) 1.....10 보일때 10, 31 32 보일때 32
	private boolean prev, next; // list.jsp에서 '이전' '다음' 버튼을 보일지 여부를 표현

	private int total; // 전체 레코드 수 표현
	private Criteria cri; // 현재 페이지와 화면의 출력될 게시물 수를 표현

	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;

		endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		startPage = endPage - 9;

		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

		if (realEnd < endPage) {
			endPage = realEnd;
		}
		prev = startPage > 1;
		next = endPage < realEnd;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getTotal() {
		return total;
	}

	public Criteria getCri() {
		return cri;
	}
	
}
