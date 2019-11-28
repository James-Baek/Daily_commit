package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.TotalList;

@Mapper
public interface TotalListDAO {
	public List<TotalList> searchByCondition(PageBean bean) throws SQLException; // List 리턴
	public TotalList isUnique(TotalList totallist) throws SQLException; // 이게 유일하냐
	public void addList(TotalList totallist) throws SQLException; // 리스트 추가
	public void updateList(TotalList totallist) throws SQLException; // 리스트 업데이트
	public void deleteList(int no) throws SQLException; // 리스트 삭제
	public int count(PageBean bean) throws SQLException;
	public TotalList foodsearch(TotalList totallist) throws SQLException; // food 정보 가져오기
	public List<Integer> bestfood() throws SQLException;
}
