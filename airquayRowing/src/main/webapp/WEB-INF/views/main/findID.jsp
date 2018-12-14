<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Airquay rowing management system</title>
<link type="text/css" rel="stylesheet" href="http://localhost:8080/rowing/resources/css/rowingCommon.css?sdf">
<link type="text/css" rel="stylesheet" href="http://localhost:8080/rowing/resources/css/rowingSignup.css?sdf">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css?sdf">

<script src="http://localhost:8080/rowing/resources/js/rowingCommon.js?sdf"></script>
<script src="https://code.jquery.com/jquery-3.0.0.min.js?sdf"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js?sdf"></script>
<script type="text/javascript">


$(document).ready(function() {
	doResize();
	dispSignupPage();
});

function doResize(){
	var windowHeight = $(window,parent.Document).height();
	var headerAreaHeight = $("#headerArea").height();
	var bottomAreaHeight = $("#bottomArea").height();
	$("#bodyArea").css("height", windowHeight-headerAreaHeight-bottomAreaHeight);
}
function dispSignupPage(){
	$("#bodyArea").css("display", "block");
}

function findID(){
	var json_data = "user_name="+($("#user_name").val());
	var url = 'http://localhost:8080/rowing/main/findUserID';
	console.log("addUser")
	$.ajax({
		url:url,
		type : 'GET',
		cache: false,
		contentType: false,
		processData: false,
		data : json_data,
		success : function(data){		
			length=data.length;
			var innerHtml="";
			if(length==0)
				alert("일치하는 아이디가 없습니다.");
			else{
				innerHtml+=($("#user_name").val())+"님의 아이디 : \n"+data[0]
				for(var i=1;i<length;i++){
					innerHtml+=" , "+data[i]
				}
				alert(innerHtml);
			}
		},
		error : function(data){
			
		}
	});
}
function main(){
	location.href="main";
}


</script>
</head>

<body style="margin: 0px; background-color: #3e6699; overflow: hidden;">
	<div id="headerArea">
		<div id="titleArea">
			<table style="width:100%;height:100%;">
				<tr>
					<td style="cursor: pointer;"onclick="javascript:main();">Rowing Management System</td>
					<td><input type="button"value="Logout"onclick="common.Logout();"style="width:40%;height:70%;font-size:20px;"></td>
				</tr>
			</table>
		</div>
	</div>
	<div id="bodyArea" style="display: none;">
	<img alt="" id="LoginImage" src="http://localhost:8080/rowing/resources/img/main_visual_01.jpg" style="width:100%;">
		<div id="SignupArea">
			<div style="float: left; width: 100%; height: 50px; font-size: 30px; text-indent: 30px; font-weight: bold; margin-top: 20px;">Enter your name</div>
			<div style="float: left; width: 100%;">
				<div style="float: left; width: 65%;">
					<div style="height: 50px;">					
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="loginLabel">Name</div>
						<div class="inputText"><input id="user_name" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {findID();}"/></div>
					</div>				
				</div>
				<div style="float:left;width: 35%;margin-top:50px;" onclick="javascript:findID();">
					<div id="Button">Submit</div>
				</div>
			</div>
		</div>
	</div>
	<div id="bottomArea"></div>
</body>
</html>