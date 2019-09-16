package com.encore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.encore.domain.BoardVO;
import com.encore.domain.Criteria;
import com.encore.domain.PageDTO;
import com.encore.domain.TestVO;
import com.encore.service.BoardService;

@Controller
@RequestMapping("/board/*") // 공통 매핑정의
public class BoardController {

	@Autowired
	BoardService service;

	// (전체)게시물 목록보기
	// @RequestMapping("/list")
	@GetMapping("/list")
	public String list(Model model, Criteria cri) {

		// model.addAttribute(new Person()); ==> 기본키: "person"

		// 자료형 List<BoardVO>
		// model.addAttribute(service.getList()); //==> 기본키: "list"
		model.addAttribute("list", service.getList(cri));

		int total = service.getTotal(cri);

		model.addAttribute("pageMaker", new PageDTO(cri, total));

		return "board/list";
	}

	// 게시물 입력폼보기
	@GetMapping("/register")
	public void getRegister() {
		// return "board/register";생략 ==> URL요청과 응답JSP경로가 같을때!!
	}

	// 게시물 DB입력
	@PostMapping("/register")
	public String postRegister(BoardVO vo, RedirectAttributes attrs) {
		// return "board/register";생략 ==> URL요청과 응답JSP경로가 같을때!!

		System.out.println("게시글 등록 vo==>" + vo);
		int bno = service.register(vo); // ==>DB입력

		attrs.addFlashAttribute("result", bno);
		// return "board/list";//포워드이동(문제점: 입력된 정보와 DB입력 프로세스를 기억!!)
		return "redirect:/board/list";// 리다이렉트이동(앞페이지의 request정보를 공유하지 않음!!)
	}

	// 특정번호의 게시물 읽기
	@GetMapping("/get") // /board/get
	public String get(int bno, Model model,Criteria cri) {
		model.addAttribute("board", service.get(bno));
		model.addAttribute("cri", cri);
		return "board/get"; // get.jsp
	}

	// 게시물 수정폼보기
	@GetMapping("/modify") // /board/modify?bno=5
	public String getModify(int bno, Model model, Criteria cri) {
		model.addAttribute("board", service.get(bno));
		model.addAttribute("cri", cri);
		return "board/modify"; // modify.jsp
	}

	// 게시물 DB수정
	@PostMapping("/modify") // /board/modify?BoardVO관련파라미터
	public String postModify(BoardVO board, RedirectAttributes attr, Criteria cri) {
		System.out.println("수정처리 cri>>" + cri.getPageNum());
		if (service.modify(board)) {// 수정요청
			attr.addFlashAttribute("result", "success");// 목록보기에서 [처리완료]메시지 보이기 위해
		}
		return "redirect:/board/list?pageNum="+cri.getPageNum(); // list.jsp
	}

	@GetMapping("/remove")
	public String getRemove(int bno, RedirectAttributes attr) {

		if (service.remove(bno)) {// 삭제요청
			attr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

	@GetMapping("/test")
	public void test1() {
	}

	@PostMapping("/test")
	public void test2(TestVO vo) {

		System.out.println("testVO>>>" + vo);

	}
}
