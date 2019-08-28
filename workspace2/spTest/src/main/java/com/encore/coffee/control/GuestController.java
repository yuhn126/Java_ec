package com.encore.coffee.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.encore.coffee.domain.GuestVO;
import com.encore.coffee.persistence.GuestDAO;

@Controller
@RequestMapping("/guest")
public class GuestController {
	
	@Autowired
	private GuestDAO dao;
	
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String inputForm() {
		return "guest/inputForm";
	}
	
	@RequestMapping(value="/form", method = RequestMethod.POST)
	public String input(GuestVO vo) {
		dao.insert(vo);
		return "redirect:/guest/list";
	}
	
	@RequestMapping("/list")
	//public String list(Model m, int page, int limit) {
	//	int page = Integer.parseInt(request.getParameter("page"));
	public String list(Model m, Integer page, Integer limit) {
		int pageNo,limitNo;
		if(page == null) pageNo = 1;
		else pageNo = page;
		
		if(limit == null) limitNo=10;
		else limitNo= limit;

		m.addAttribute("page", pageNo);
		m.addAttribute("limit", limitNo);
		
		m.addAttribute("list", dao.selectPage(pageNo, limitNo));
		
		return "guest/list";
	}
	
	@RequestMapping(value = "/upform", method = RequestMethod.GET) //수정폼 보이기
	public String upForm(int no, Model m) {
		m.addAttribute("vo",dao.select(no));
		return "guest/editForm";
	}
	
	@RequestMapping(value = "/upform", method = RequestMethod.POST)
	public String update(GuestVO vo) {
		dao.update(vo);
		return "redirect:/guest/list";
	}
	
	@RequestMapping("/delete")//DB삭제하기
	public String delete(int no) {
		dao.delete(no);
		return "redirect:/guest/list";
	}
	
}
