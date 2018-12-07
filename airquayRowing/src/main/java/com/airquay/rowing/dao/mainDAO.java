package com.airquay.rowing.dao;

import java.util.List;

import com.airquay.rowing.vo.main;

public interface mainDAO {

	List checkUser(main main);

	List getUserInfo(main main);

	void addUser(main main);

	List getTeamList();
	
	List getRoundtypeList();
	
	List getStartYear();

	List getRecord(main main);
	
	void addData(main main);
}
