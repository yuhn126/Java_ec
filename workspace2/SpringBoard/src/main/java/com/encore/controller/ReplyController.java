package com.encore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.domain.ReplyVO;
import com.encore.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	@Autowired
	private ReplyService service;
	
	@PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {//html에 있는 json을 vo로 변환
		int insertCnt = service.register(vo); //insertCnt ==> 추가된 행의 갯수
		System.out.println("insertCnt >> " + insertCnt);
		return (insertCnt == 1) ? new ResponseEntity<>("success",HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value = "/new2")
	public String create2(ReplyVO vo) {
		int insertCnt = service.register(vo); //insertCnt ==> 추가된 행의 갯수
		return (insertCnt == 1) ? "success"	:"fail";
	}
	
}
