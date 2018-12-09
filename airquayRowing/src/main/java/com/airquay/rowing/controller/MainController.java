package com.airquay.rowing.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airquay.rowing.vo.main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@Controller
public class MainController {
	
	@Autowired
	private com.airquay.rowing.service.rowingService rowingService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)//http://localhost:8080/airquayRowing/main ���� �� ȣ��
	public String main(Model model, HttpServletRequest request, HttpServletResponse response) {
 		HttpSession session = request.getSession();
 		Boolean loginUser = (Boolean) session.getAttribute("loginUser");
		if(loginUser==null){
			model.addAttribute("loginCheck", false);
		}else{
			model.addAttribute("loginCheck", true);
		}
		return "main/login";
	}
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String select(Model model, HttpServletRequest request, HttpServletResponse response) {
		return "main/select";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model, HttpServletRequest request, HttpServletResponse response) {
		return "main/signup";
	}
	
	@RequestMapping(value = "/addRecord", method = RequestMethod.GET)
	public String addRecord(Model model, HttpServletRequest request, HttpServletResponse response) {
		return "main/addRecord";
	}
	
	@RequestMapping(value = "/recordview", method = RequestMethod.GET)
	public String recordview(Model model, HttpServletRequest request, HttpServletResponse response) {
		return "main/recordView";
	}
	
	@RequestMapping(value = "/selectAdmin", method = RequestMethod.GET)
	public String selectAdmin(Model model, HttpServletRequest request, HttpServletResponse response) {
		return "main/selectAdmin";
	}
	
	@RequestMapping(value = "/teamInfo", method = RequestMethod.GET)
	public String teamInfo(Model model, HttpServletRequest request, HttpServletResponse response) {
		return "main/teamInfo";
	}

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })//�α������� Ȯ�� �� true/false��ȯ
	public @ResponseBody List login(Model model, HttpServletRequest request, HttpServletResponse response) {
		main main = new main();
		List<Object> resultList = new ArrayList<Object>();
		HttpSession session = request.getSession(false);
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		main.setUser_id(user_id);
		main.setUser_pw(user_pw);
		Boolean userCheck = rowingService.checkUser(main);
		List<List> userInfo = rowingService.userInfo(main);
		if(userCheck==true){
			model.addAttribute("userInfo",userInfo);
			session.setAttribute("loginUser", true);
			resultList.add(0, userInfo);
			resultList.add(1, userCheck);
		}
		else {
			resultList.add(0, userInfo);
			resultList.add(1, userCheck);
		}
		return resultList;
	}
  	
	@RequestMapping(value = "/main/addUser", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody void addUser(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
  		String user_id=request.getParameter("user_id");
  		String user_pw=request.getParameter("user_pw");
  		String user_name=request.getParameter("user_name");
  		String team_num=request.getParameter("team_num");
  		
  		main main=new main();
  		main.setUser_id(user_id);
  		main.setUser_pw(user_pw);
  		main.setUser_name(user_name);
  		main.setTeam_num(Integer.parseInt(team_num));
  		
  		rowingService.addUser(main);
	}
	
	@RequestMapping(value = "/main/addData", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody void addData(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
  		String event_name=request.getParameter("event_name");
  		String year=request.getParameter("year");
  		String month=request.getParameter("month");
  		String day=request.getParameter("day");
  		String race_date=year+"-"+month+"-"+day;
  		String racetype=request.getParameter("race_type");
  		String progression=request.getParameter("progression");
  		String roundtype=request.getParameter("round_type");
  		String RankOneTeam=request.getParameter("RankOneTeam");
  		String RankOneRacetime=request.getParameter("RankOneRacetime");
  		String RankTwoTeam=request.getParameter("RankTwoTeam");
  		String RankTwoRacetime=request.getParameter("RankTwoRacetime");
  		String RankThreeTeam=request.getParameter("RankThreeTeam");
  		String RankThreeRacetime=request.getParameter("RankThreeRacetime");
  		String RankFourTeam=request.getParameter("RankFourTeam");
  		String RankFourRacetime=request.getParameter("RankFourRacetime");
  		String RankFiveTeam=request.getParameter("RankFiveTeam");
  		String RankFiveRacetime=request.getParameter("RankFiveRacetime");
  		String RankSixTeam=request.getParameter("RankSixTeam");
  		String RankSixRacetime=request.getParameter("RankSixRacetime");		
  		
  		main main=new main();
  		main.setEvent_name(event_name);
  		main.setRace_date(race_date);
  		main.setRacetype(racetype);
  		main.setProgression(progression);
  		main.setRoundtype(roundtype);
  		main.setRankOneTeam(RankOneTeam);
  		main.setRankOneRacetime(RankOneRacetime);
  		main.setRankTwoTeam(RankTwoTeam);
  		main.setRankTwoRacetime(RankTwoRacetime);
  		main.setRankThreeTeam(RankThreeTeam);
  		main.setRankThreeRacetime(RankThreeRacetime);
  		main.setRankFourTeam(RankFourTeam);
  		main.setRankFourRacetime(RankFourRacetime);
  		main.setRankFiveTeam(RankFiveTeam);
  		main.setRankFiveRacetime(RankFiveRacetime);
  		main.setRankSixTeam(RankSixTeam);
  		main.setRankSixRacetime(RankSixRacetime);
  		
  		rowingService.addData(main);
	}
	
	@RequestMapping(value = "/main/getteamList", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody List getteamList(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		List<List> teamInfo = rowingService.getteamList();
		return teamInfo;
	}
	
	@RequestMapping(value = "/main/getRoundtypeList", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody List getRoundtypeList(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		List<List> RoundtypeInfo = rowingService.getRoundtypeList();
		return RoundtypeInfo;
	}
	
	@RequestMapping(value = "/main/getStartYear", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody List getStartYear(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		List<List> startYear = rowingService.getStartYear();
		return startYear;
	}
	
	@RequestMapping(value = "/main/getRecord", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody List getRecord(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		main main=new main();
		
		main.setStart_date(request.getParameter("startDate"));
		main.setEnd_date(request.getParameter("endDate"));
		main.setTeam_num(Integer.parseInt(request.getParameter("team_num")));
		main.setRoundtype_key(Integer.parseInt(request.getParameter("roundtype_key")));
		
		List<List> record_info = rowingService.getRecord(main);
		return record_info;
	}
	
	@RequestMapping(value = "/main/teamData", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Vector teamData(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String team_num=request.getParameter("team_num");		
		Vector teamInfo = rowingService.teamInfo(team_num);
		return teamInfo;
	}
}