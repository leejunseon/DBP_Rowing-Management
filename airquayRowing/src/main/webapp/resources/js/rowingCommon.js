var common={
		
	//팀 정보 가져옴
	getteamList : function(){
		var json_data = " ";
		$.ajax({
			url:'http://localhost:8080/airquayRowing/main/getteamList',
			type : 'GET',
			cache: false,
			contentType: false,
			processData: false,
			data : json_data,
			dataType : 'json',
			success : function(data){
				if(data.length>0){
					teamInfo = data;
					var innerHtml = "<option value='' selected disabled hidden>team</option>";
					for(var i=0; i<teamInfo.length; i++){
						innerHtml += "<option value="+(teamInfo[i].team_num)+">"+teamInfo[i].team_name+"</option>"
					}
					$("#teams").empty().append(innerHtml);
				}
			},
			error : function(data){
			}
		});
	},
	
	//경기 종류 가져옴
	getRoundtypeList : function(){
		var json_data = " ";
		$.ajax({
			url:'http://localhost:8080/airquayRowing/main/getRoundtypeList',
			type : 'GET',
			cache: false,
			contentType: false,
			processData: false,
			data : json_data,
			dataType : 'json',
			success : function(data){
				if(data.length>0){
					roundtypeInfo = data;
					var innerHtml = "<option value='' selected disabled hidden>roundtype</option>";
					for(var i=0; i<roundtypeInfo.length; i++){
						innerHtml += "<option value="+(roundtypeInfo[i].roundtype_key)+">"+roundtypeInfo[i].roundtype+"</option>"
					}
					$("#roundtypes").empty().append(innerHtml);
				}
			},
			error : function(data){
			}
		});
	},
	
	//시작 년도 가져옴
	getStartYear : function(){
		var json_data = " ";
		$.ajax({
			url:'http://localhost:8080/airquayRowing/main/getStartYear',
			type : 'GET',
			cache: false,
			contentType: false,
			processData: false,
			data : json_data,
			dataType : 'json',
			success : function(data){
				if(data.length>0){
					startYear = data;
					var innerHtml = "<option value='' selected disabled hidden>year</option>";
					for(var i=0; i<startYear.length; i++){
						innerHtml += "<option value="+(startYear[i])+">"+startYear[i]+"</option>"
					}
					$("#startYear").empty().append(innerHtml);
					
					innerHtml="<option value='' selected disabled hidden>year</option>";
					for(var i=startYear[startYear.length-1]; i<=startYear[startYear.length-1]+5; i++){
						innerHtml += "<option value='"+i+"''>"+i+"</option>"
					}
					$("#endYear").empty().append(innerHtml);
				}
			},
			error : function(data){
			}
		});
	},
	
	displayRecord : function(){
		var json_data = "startDate="+($("#startYear").val())+"-"+($("#startMonth").val())+"-"+($("#startDay").val())+
						"&endDate="+($("#endYear").val())+"-"+($("#endMonth").val())+"-"+($("#endDay").val())+
						"&team_num="+($("#teams").val())+
						"&roundtype_key="+($("#roundtypes").val());
		$.ajax({
			url:'http://localhost:8080/airquayRowing/main/getRecord',
			type : 'GET',
			cache: false,
			contentType: false,
			processData: false,
			data : json_data,
			dataType : 'json',
			success : function(data){
				records=data;
				var innerHtmlInfo = "";
				var innerHtml500 = "";
				var innerHtml1000 = "";
				var innerHtml1500 = "";
				var innerHtmlFinish = "";
				var innerHtmlRank="";
				for(var i=0; i<records.length; i++){
					if(records[i].finish_time!=null){
						innerHtmlInfo+=records[i].event_name+"  <"+records[i].race_date+"><hr>";
						innerHtmlRank+=records[i].rank+"<hr>";
						if(records[i].fivehundred_time!=null)
							innerHtml500 += records[i].fivehundred_time+"<hr>";
						else
							innerHtml500 += "-"+"<hr>";
						if(records[i].thousand_time!=null)
							innerHtml1000 += records[i].thousand_time+"<hr>";
						else
							innerHtml1000 += "-"+"<hr>";
						if(records[i].thousandfivehundred_time!=null)
							innerHtml1500 +=records[i].thousandfivehundred_time+"<hr>";
						else
							innerHtml1500 += "-"+"<hr>";
						if(records[i].finish_time!=null)
							innerHtmlFinish +=records[i].finish_time+"<hr>";
						else
							innerHtmlFinish += "-"+"<hr>";
					}
				}
				$("#recordinfo").empty().append(innerHtmlInfo);
				$("#record500").empty().append(innerHtml500);
				$("#record1000").empty().append(innerHtml1000);
				$("#record1500").empty().append(innerHtml1500);
				$("#finish").empty().append(innerHtmlFinish);
				$("#rank").empty().append(innerHtmlRank);
			},
			error : function(data){
				console.log("displayRecord error")
			}
		});
	},
				
}