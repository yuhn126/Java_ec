package com.encore.dvdShop.model.dao;

import java.util.List;

import com.encore.db.iba.MySqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClient;

public class MovieDAO {
	SqlMapClient smc;
	
	public MovieDAO() {
		smc = MySqlMapClient.getSqlMapInstance();
	}
	
	public List<MovieDAO> selectAll(){
		return null;
	}
}
