package com.airquay.rowing.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.airquay.rowing.vo.main;

@Repository
public class mainDaoImpl  implements mainDAO{
	@Autowired
	private SqlSession sqlSession;
	
	private String mapper = "mapper.main.";
	
	@Override
	public List checkUser(main main) {
		// TODO Auto-generated method stub
		List userCheck = sqlSession.selectList(mapper+"checkUser", main);
		return userCheck;
	}

	@Override
	public List getUserInfo(main main) {
		// TODO Auto-generated method stub
		List userInfo = sqlSession.selectList(mapper+"getUserInfo", main);
		return userInfo;
	}
	
	@Override
	public void addUser(main main) {
		// TODO Auto-generated method stub
		sqlSession.insert(mapper+"addUser", main);
	}

	@Override
	public void addData(main main) {
		// TODO Auto-generated method stub
		
		String[] RankTeams=new String[6];
		RankTeams[0]=main.getRankOneTeam();
		RankTeams[1]=main.getRankTwoTeam();
		RankTeams[2]=main.getRankThreeTeam();
		RankTeams[3]=main.getRankFourTeam();
		RankTeams[4]=main.getRankFiveTeam();
		RankTeams[5]=main.getRankSixTeam();
		
		for(int i=0;i<6;i++) {
			if(RankTeams[i]!="")
				sqlSession.insert(mapper+"addRankteams",RankTeams[i]);
		}
	
		sqlSession.insert(mapper+"addRacetype",main);
		sqlSession.insert(mapper+"addRoundtype",main);
		sqlSession.insert(mapper+"addProgression",main);
		
		main.setRacetype_key(sqlSession.selectOne(mapper+"getRacetypeKey",main));
		main.setRoundtype_key(sqlSession.selectOne(mapper+"getRoundtypeKey",main));
		main.setProgression_key(sqlSession.selectOne(mapper+"getProgressionKey",main));
		
		sqlSession.insert(mapper+"addRaceinfo",main);
		
		main.setRace_num(sqlSession.selectOne(mapper+"getRacenum"));
		
		for(int i=1;i<=6;i++) {
			if(RankTeams[i-1]!="") {
				String I=Integer.toString(i);
				sqlSession.insert(mapper+"addRecordinfo"+I,main);	
			}
		}
	}
	
	@Override
	public List getTeamList() {
		// TODO Auto-generated method stub
		List teamList=sqlSession.selectList(mapper+"getTeamList");
		return teamList;
	}

	@Override
	public List getRecord(main main) {
		// TODO Auto-generated method stub
		List record;
		List<List> record_info=new ArrayList<List>();
		
		List<Integer> race_numList=sqlSession.selectList(mapper+"getRecordRacenum",main);

		for(int i=0;i<race_numList.size();i++) {
			main.setRace_num(race_numList.get(i));
			record=sqlSession.selectList(mapper+"getRecord",main);
			record_info.add(record);
		}
		return record_info;
	}

	@Override
	public List getRoundtypeList() {
		// TODO Auto-generated method stub
		List RoundtypeList=sqlSession.selectList(mapper+"getRoundtypeList");
		return RoundtypeList;
	}

	@Override
	public List getStartYear() {
		// TODO Auto-generated method stub
		List startYear=sqlSession.selectList(mapper+"getStartYear");
		return startYear;
	}

	@Override
	public Vector teamInfo(String team_num) {
		// TODO Auto-generated method stub
		Vector teamInfo=new Vector(6);
	
		List records = sqlSession.selectList(mapper+"getRecordsInfo",Integer.parseInt(team_num));
		Integer ChampionNum=sqlSession.selectOne(mapper+"getChampionNum",Integer.parseInt(team_num));
		Double AvgRank=sqlSession.selectOne(mapper+"getAvgRank",Integer.parseInt(team_num));
		String AvgRaceTime=sqlSession.selectOne(mapper+"getAvgRaceTime",Integer.parseInt(team_num));
		Integer Abstention=sqlSession.selectOne(mapper+"getAbstention",Integer.parseInt(team_num));
		Integer Disqualification=sqlSession.selectOne(mapper+"getDisqualification",Integer.parseInt(team_num));

		teamInfo.add(records);
		teamInfo.add(ChampionNum);
		teamInfo.add(AvgRank);
		teamInfo.add(AvgRaceTime);
		teamInfo.add(Abstention);
		teamInfo.add(Disqualification);
		
		return teamInfo;
	}

	@Override
	public void addRace(main main) {
		// TODO Auto-generated method stub
		sqlSession.insert(mapper+"addRace",main);
	}

	@Override
	public List getUserList() {
		// TODO Auto-generated method stub
		List UserInfo=sqlSession.selectList(mapper+"getUserList");
		return UserInfo;
	}

	@Override
	public void setUserInfo(String[] user_num) {
		// TODO Auto-generated method stub
		sqlSession.update(mapper+"setUserAdmin");
		for(int i=0;i<user_num.length;i++) {
			sqlSession.update(mapper+"setUserInfo",Integer.parseInt(user_num[i]));
		}
	}

	@Override
	public List getRaceSchedule() {
		// TODO Auto-generated method stub
		List raceSchedule=sqlSession.selectList(mapper+"getRaceSchedule");
		return raceSchedule;
	}

	@Override
	public void deletelaterSchedule() {
		// TODO Auto-generated method stub
		sqlSession.delete(mapper+"deletelaterSchedule");
	}
}
