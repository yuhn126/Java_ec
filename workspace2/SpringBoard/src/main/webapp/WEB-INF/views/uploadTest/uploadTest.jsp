<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>포트폴리오 등록</title>
<script src="/porget/js/jquery-3.js"></script>
<link rel="stylesheet" href="/porget/css/portfolioPost.css">
<script type="text/javascript">
	var fileCount =0; /* 업로드된 파일 갯수 확인을 위한 변수 */
	var fileList = new FormData(); /* 선택한 파일들을 임시로 담고 있을 formData */
	var formData = new FormData(); /* ajax로 전달할 formData */
	
	function isImageFile( fileName ) {// 확장자를 통한 이미지 파일 확인
	    var fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);
	    fileSuffix = fileSuffix.toLowerCase();
	    if ( "jpg" == fileSuffix || "jpeg" == fileSuffix  || "gif" == fileSuffix || "bmp" == fileSuffix || "png" == fileSuffix ) 
	        return true;
	    else 
	        return false;
	}
	
	$(function(){
		$('#uploadBtn').on("click", function(e){//제출버튼 클릭했을시
			if(fileCount===0){//파일 갯수 유효성 검사
				alert('썸네일을 하나 이상 첨부해주세요');
				$('#uploadFile').focus();
				return;
			}
			
			
			for(var i=0;i<fileCount;i++){//fileList의 저장된 파일 formData에 key값'uploadFile'로 저장하기
										//FormData는 같은 key값으로 저장시 배열형태로 중첩됨
				formData.append("uploadFile",fileList.get($("#dataList tr").eq(i).children("td:eq(0)").html()));
			}
			
			$.ajax({
				url:'post',
				processData:false,
				contentType:false,
				data:formData,
				type:'POST',
				success:function(result){
					alert("Uploaded");
					window.location = '/porget/portfolio'
				}
			});
			//console.log($('input[name=pfname]:eq(0)').val());
		});//#uploadBtn.on click
		
		
		$("input[name='uploadFile']:eq(0)").on("change",function(){//업로드 파일 선택시
			var alNum=0;//jpg가 아닌 파일을 2개 이상 업로드 했을때 알람은 1번만 띄우기 위한 변수
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files;
			var fileIn =(parseFloat(files.length)+parseFloat(fileCount));//이미 등록되어 있는 파일의 갯수와 추가로 선택한 파일갯수의 합계
			if(fileCount>2){
				alert("파일이 이미 3개있습니다");
				$(this).val("");return;}
			console.log("f+f : "+(files.length+fileCount));
			if(fileIn>3){//선택된 파일 중 올릴 갯수(fileIn) 정하기
				alert("파일은 3개까지 등록됩니다");
				fileIn = (3-parseFloat(fileCount));
			}else{fileIn=files.length;}
			console.log("filecount : "+ fileCount);
			for(var i=0;i<fileIn;i++){//정해진 갯수(fileIn)만큼 input으로 선택된 파일 임시 저장
				if(isImageFile(files[i].name)){//확장자 확인으로 이미지 확인
				fileList.append(files[i].name,files[i]);//키값: fileName 으로 fileList에 파일 임시 저장
				//$("input[name='uploadFile']:eq(0)").val().split("\\")
				$('#dataList').html($('#dataList').html()+"<tr><td>"+files[i].name+"</td>"+
					"<td><button>삭제</button></td></tr>");
				//뷰에 임시 저장된 파일 표시 및 삭제버튼 생성
				fileCount ++;
				}else{
					if(alNum==0){
						alert("이미지만 등록해주세요");
						alNum=1;
					}
				}
			}
				console.log("3 : "+$('#dataList tr:eq(0) td:eq(0)').html());
			$(this).val("")//input 태그 초기화
		})//썸네일 목록 등록
		
		$('#dataList').on('click','button',function(){//생성된 삭제버튼으로 임시 저장된 파일 삭제
			console.log("삭제");
			fileList.delete($(this).closest('tr').children('td:eq(0)').html());
			//fileList에 키값:fileName 삭제하기 굳이 필요한가...?
			$(this).closest('tr').remove();
			//뷰에서 삭제
			fileCount -= 1;
		});//삭제버튼
	});
</script>

</head>
<body>
	<form id="contact-form" class="form" action="#" method="POST" role="form">
		<div class="form-group">
			<label for="uploadFile">사진 등록</label>
			 <input	type="file" class="form-control" id="uploadFile"
				name="uploadFile" placeholder="썸네일 등록" tabindex="5" required
				multiple accept=".jpg,.jpeg,.gif,.bmp,.png" style="width:110px;">
				<!-- multiple 속성으로 파일 여러개 추가가능 -->
			<table class="table"><!-- 선택한 파일들이 입력되는 테이블 -->
				<thead>
					<tr>
						<th width="500px">사진제목</th>
						<th width="300px">삭제</th>
					</tr>
				</thead>
				<tbody id="dataList">
				</tbody>
			</table>
			<br>
		</div>
		<div class="text-center">
			<button type="button" class="btn btn-primary" id='uploadBtn'>등록</button>
		</div>
	</form>
</body>
</html>