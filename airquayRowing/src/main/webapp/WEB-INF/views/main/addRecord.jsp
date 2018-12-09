<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Airquay rowing management system</title>
<link type="text/css" rel="stylesheet" href="http://localhost:8080/airquayRowing/resources/css/rowingCommon.css?ver=2">
<link type="text/css" rel="stylesheet" href="http://localhost:8080/airquayRowing/resources/css/rowingAddrace.css?ver=2">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css?ver=2">

<script src="http://localhost:8080/airquayRowing/resources/js/rowingCommon.js?ver=2"></script>
<script src="https://code.jquery.com/jquery-3.0.0.min.js?ver=2"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js?ver=2"></script>
<script type="text/javascript">

$(document).ready(function() {
	doResize();
	dispSignupPage();
});

function doResize(){
	var windowHeight = $(window).height();
	var headerAreaHeight = $("#headerArea").height();
	var bottomAreaHeight = $("#bottomArea").height();
	$("#bodyArea").css("height", windowHeight-headerAreaHeight-bottomAreaHeight);
	//$("#bodyArea",parent.document).css("height",776)//임시방편
}
function dispSignupPage(){
	$("#bodyArea").css("display", "block");
}
function addData(){
	var json_data = "event_name="+($("#event_name").val());
		json_data += "&year="+($("#year").val());
		json_data += "&month="+($("#month").val());
		json_data += "&day="+($("#day").val());
		json_data += "&race_type="+($("#race_type").val());
		json_data += "&round_type="+($("#round_type").val());
		json_data += "&progression="+($("#progression").val());
		json_data += "&RankOneTeam="+($("#RankOneTeam").val());
		json_data += "&RankOneRacetime="+($("#RankOneRacetime").val());
		json_data += "&RankTwoTeam="+($("#RankTwoTeam").val());
		json_data += "&RankTwoRacetime="+($("#RankTwoRacetime").val());
		json_data += "&RankThreeTeam="+($("#RankThreeTeam").val());
		json_data += "&RankThreeRacetime="+($("#RankThreeRacetime").val());
		json_data += "&RankFourTeam="+($("#RankFourTeam").val());
		json_data += "&RankFourRacetime="+($("#RankFourRacetime").val());
		json_data += "&RankFiveTeam="+($("#RankFiveTeam").val());
		json_data += "&RankFiveRacetime="+($("#RankFiveRacetime").val());
		json_data += "&RankSixTeam="+($("#RankSixTeam").val());
		json_data += "&RankSixRacetime="+($("#RankSixRacetime").val());
	var url = 'http://localhost:8080/airquayRowing/main/addData';
	$.ajax({
		url:url,
		type : 'GET',
		cache: false,
		contentType: false,
		processData: false,
		data : json_data,
		success : function(data){		
			resultAddData(true);
		},
		error : function(data){
			resultAddData(false);
		}
	});
}
function resultAddData(data){
	location.href="select";
}
</script>
</head>

<body style="margin: 0px; background-color: #3e6699; overflow: auto;">
	<div id="headerArea">
		<div id="titleArea">Rowing Management System</div>
	</div>
	<div id="bodyArea" style="display: none;">
	<img alt="" id="LoginImage" src="http://localhost:8080/airquayRowing/resources/img/main_visual_01.jpg" style="width:100%;">
		<div id="addraceArea">
			<div style="float: left; width: 100%; height: 50px; font-size: 30px; text-indent: 30px; font-weight: bold; margin-top: 20px;">Race info</div>
			<div style="float: left; width: 100%;">
				<div style="float: left; width: 27%;">
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel"></div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">Event name</div>
						<div class="inputText"><input id="event_name" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">Year</div>
						<div class="inputText"><input id="year" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">Month</div>
						<div class="inputText"><input id="month" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">Day</div>
						<div class="inputText"><input id="day" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">Race type</div>
						<div class="inputText"><input id="race_type" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">Round type</div>
						<div class="inputText"><input id="round_type" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">Progression</div>
						<div class="inputText"><input id="progression" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
				</div>
				<div style="float: left; width: 27%;">
					<div style="margin-left:25%; width: 100%; height: 50px;">
						<div class="raceLabel">-- Rank 1 --</div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">Team</div>
						<div class="inputText"><input id="RankOneTeam" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">RaceTime</div>
						<div class="inputText"><input id="RankOneRacetime" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="margin-left:25%; width: 100%; height: 50px;">
						<div class="raceLabel">-- Rank 2 --</div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">Team</div>
						<div class="inputText"><input id="RankTwoTeam" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">RaceTime</div>
						<div class="inputText"><input id="RankTwoRacetime" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="margin-left:25%; width: 100%; height: 50px;">
						<div class="raceLabel">-- Rank 3 --</div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">Team</div>
						<div class="inputText"><input id="RankThreeTeam" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">RaceTime</div>
						<div class="inputText"><input id="RankThreeRacetime" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
				</div>
				<div style="float: left; width: 27%;">
					<div style="margin-left:25%; width: 100%; height: 50px;">
						<div class="raceLabel">-- Rank 4 --</div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">Team</div>
						<div class="inputText"><input id="RankFourTeam" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">RaceTime</div>
						<div class="inputText"><input id="RankFourRacetime" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="margin-left:25%; width: 100%; height: 50px;">
						<div class="raceLabel">-- Rank 5 --</div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">Team</div>
						<div class="inputText"><input id="RankFiveTeam" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">RaceTime</div>
						<div class="inputText"><input id="RankFiveRacetime" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="margin-left:25%; width: 100%; height: 50px;">
						<div class="raceLabel">-- Rank 6 --</div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">Team</div>
						<div class="inputText"><input id="RankSixTeam" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
					<div style="float: left; width: 100%; height: 50px;">
						<div class="raceLabel">RaceTime</div>
						<div class="inputText"><input id="RankSixRacetime" type="text" style="width: 100%; height: 100%;" onKeyDown="if(event.keyCode==13) {login();}"/></div>
					</div>
				</div>
				<div style="float: right; margin-right:40px; margin-top:350px;"onclick="javascript:addData();">
					<div id="SignupBtn">Submit</div>
				</div>
			</div>
		</div>
	</div>
	<div id="bottomArea"></div>
</body>
</html>