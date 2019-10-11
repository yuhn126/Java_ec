package com.encore.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {
		
	}
	
	@PostMapping("/uploadformAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		String uploadFolder = "C:\\beaudafest";
		
		for(MultipartFile multipartFile : uploadFile) {
			System.out.println("Upload File Name : " + multipartFile.getOriginalFilename());
			System.out.println("Upload File Size : " + multipartFile.getSize());
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			//IE경로
			uploadFileName=uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			System.out.println("onlyFileName"+uploadFileName);
			
			File savefile = new File(uploadFolder, uploadFileName);
			try {
				multipartFile.transferTo(savefile);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		
	}
	
	@PostMapping("/uploadAjaxAction")
	public void uploadAjaxPost(MultipartFile[] uploadFile) {
		String uploadFolder = "C:\\beaudafest";
		
		String addDate= getFolder();//혹시 그 사이에 날짜 바뀔까봐..
		
		File uploadPath = new File(uploadFolder, addDate);
		
		String shopPhoto="";//db저장용 변수
		if(uploadPath.exists()==false) {//오늘 날짜 폴더가 없으면
			uploadPath.mkdirs(); //오늘 날짜 폴더 만들기
		}
			
			
		for(MultipartFile multipartFile : uploadFile) {
			System.out.println("Upload File Name : " + multipartFile.getOriginalFilename());
			System.out.println("Upload File Size : " + multipartFile.getSize());
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			//IE용 경로
			uploadFileName=uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			System.out.println("onlyFileName : "+uploadFileName);
			
			//중복 방지 UUID
			UUID uuid = UUID.randomUUID();
			uploadFileName=uuid.toString()+"_"+uploadFileName;
			System.out.println(uploadFileName);
			//'날짜/파일이름' 으로 DB에 저장
			shopPhoto+=((addDate+"\\"+uploadFileName)+"|");
			
			//폴더에 이미지 추가
			File savefile = new File(uploadPath, uploadFileName);
			
			try {
				multipartFile.transferTo(savefile);
				//DB에 저장할때
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
		System.out.println("shopPhoto : "+shopPhoto);
	}
	
	private String getFolder() {//오늘 날짜의 경로를 문자열로 생성
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
}
