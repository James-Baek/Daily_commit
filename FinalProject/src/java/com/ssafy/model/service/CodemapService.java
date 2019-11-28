package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.Codemap;

public interface CodemapService {
	public String searchCode(String code);
	public List<Codemap> getAllCode();
}
