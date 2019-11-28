package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.Codemap;

@Mapper
public interface CodemapDAO {
	public String searchCode(String code) throws SQLException;
	public List<Codemap> getAllCode() throws SQLException;
}
