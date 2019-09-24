package com.encore.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.domain.SampleVO;
import com.encore.domain.Ticket;

@RestController	// (JSP페이지가 아닌) 응답데이터(텍스트, JSON) 전용 컨트롤러==> Ajax요청 전용!
@RequestMapping("/sample")
public class SampleController {
	
	@RequestMapping("/getText")
	public String getText() {
		return "오왕";
	}
	
	@RequestMapping(value="/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public SampleVO getSample() {
		SampleVO vo = new SampleVO(112, "스타", "로드");
		return vo;
	}

	@RequestMapping("/getList")
	public List<SampleVO> getList() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		list.add(new SampleVO(1, "first1", "last1"));
		list.add(new SampleVO(2, "first2", "last2"));
		list.add(new SampleVO(3, "first3", "last3"));
		
		return list;
	}
	
	@RequestMapping("/getMap")
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("FirstKey", new SampleVO(111, "그루트", "주니어"));
		return map;
	}
	
	@RequestMapping(value="/check")
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		ResponseEntity<SampleVO> entity;
		if(height < 150) {
			entity = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			entity = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return entity;
	}
	
	@RequestMapping("/product/{cat}/{pid}") //요청 경로상에 사용된 {cat}, {pid}을 경로 변수라 함!
	public String[] getPath(@PathVariable("cat") String ca, @PathVariable("pid") Integer pi){
		//'경로 변수'를 사용하는 경우 {}중괄호의 갯수 만큼 메소드 매개변수에 @PathVariable선언이 있ㅇ야 하고
		//'경로 변수'와 같은 이름이 정의되어 있어야 함
		//뒤에 변수명은 메소드 바디에서 사용할 새로 정의된 변수임.
		return new String[] {"category : " + ca, "productid : " + pi};
	}
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		//@RequestBody : HTML에서(jquery Ajax에서) 전달되는 JSON을 VO로 
		System.out.println("ticket>> " + ticket);
		return ticket;
	} 
}
