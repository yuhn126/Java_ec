package com.encore.dvdShop.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.encore.dvdShop.model.vo.MovieVO;
import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class MovieDAO {
	SqlMapClient smc;
	
	public MovieDAO() {
		smc = MySqlMapClient.getSqlMapInstance();
	}
	
	public List<MovieDAO> selectAll() throws SQLException{
		return smc.queryForList("dvdShop.selectAllMovie");
	}
	
	public MovieVO selectMovie(int movCode) throws SQLException {
		return (MovieVO) smc.queryForObject("dvdShop.selectMovie", movCode);
	}
}
