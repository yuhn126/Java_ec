<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
    href="https://use.fontawesome.com/releases/v5.11.2/css/all.css"
    integrity="sha384-KA6wR/X5RY4zFAHpv/CnoG2UW1uogYfdnP67Uv7eULvTveboZJg0qUpmJZb5VqzN"
    crossorigin="anonymous">
<script src="resources/js/jquery-3.js"></script>
<script type="text/javascript">
	$(function(){
		var regex=new RegExp("(.*?)\.(jpg|jpeg|bmp|png|JPG|JPEG|BMP|PNG)$");
		var maxSize=52428880; //사이즈 할지말지!
		var fileCnt=0;
		
		function checkExtension(fileName, fileSize){
			if(fileSize >= maxSize){
				alert("파일 사이즈 초과");
				return false;
			}
			if(!regex.test(fileName)){
				alert('해당 종류의 파일은 업로드 할 수 없습니다.');
				return false;
			}
			return true;
		}
		
		//var cloneObj = $(".uploadDiv").clone();
		var formData = new FormData();
		var files = '';
		
		//파일선택했을때
		$('input[name="uploadFile"]').on("change", function(){
			$('.uploadResult ul').html('');
			var inputFile = $("input[name='uploadFile']");
			files = inputFile[0].files;
			fileCnt = files.length;
			
			for(var i=0; i<files.length; i++){
				if(!checkExtension(files[i].name, files[i].size)){
					$('.uploadResult ul').html('');
					return false;
				}
				$('.uploadResult ul').append('<li><span>'+files[i].name+'</span> <a style="cursor:pointer" class="fas fa-times"></a></li>');
				formData.append(files[i].name, files[i]);
			}
		});
		
		
		//업로드 눌렀을때
		$('#uploadBtn').on("click", function(e){
			for(var i=0; i<fileCnt; i++){//formData의 내용 갯수..?만큼 돌려야되는디...
				formData.append("uploadFile", formData.get($('.uploadResult ul').find('span:eq('+i+')').html()));
			}
			
			$.ajax({
				url : '/uploadAjaxAction',
				processData : false,
				contentType : false,
				data : formData,
				type:'POST',
				success : function(data){
					alert("Uploaded");
					showUploadedFile(data);
				}
			});
			formData = new FormData();
		})
		
		$('.uploadResult').on('click','a',function(){
			console.log($(this).siblings('span').html());
			$(this).closest('li').remove();
			fileCnt--;
		})
		
		
	});
	
</script>
</head>
<%-- uploadAjax.jsp --%>
<body>
	<h1>Upload with Ajax</h1>
	
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple accept=".jpg,.jpeg,.gif,.bmp,.png">
		
		<button id="uploadBtn">Upload</button>
	</div>
	
	<div class='uploadResult'>
		<ul>
			
		</ul>
	</div>
	
</body>

</html>