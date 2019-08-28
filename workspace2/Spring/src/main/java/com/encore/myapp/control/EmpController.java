package com.encore.myapp.control;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encore.domain.EmpVO;
import com.encore.myapp.persistence.EmpDAO2;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Inject
	private EmpDAO2 dao;
	
	@RequestMapping("/form")
	public String insertForm() {
		return "0826/emp_form";
	}
	
	@RequestMapping("/insert")
	public String insert(EmpVO vo) {
		if(dao.insertEmp(vo)) {
			return "redirect:/emp/list";
		} else {
			return "redirect:/emp/form";
		}
	}
	
	@RequestMapping("/list")
	public String selectAll(Model m, String deptno) {
		if(deptno == null||deptno.equals("")) {
			m.addAttribute("list",dao.selectAll());
		} else {
			m.addAttribute("list",dao.selectDept(Integer.parseInt(deptno)));
		}
		return "0826/emp_list";
	}
	
}
