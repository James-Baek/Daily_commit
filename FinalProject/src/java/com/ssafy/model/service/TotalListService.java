package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.TotalList;


public interface TotalListService {
	public List<TotalList> searchByCondition(PageBean bean); // List 리턴
	public TotalList isUnique(TotalList totallist);
	public void addList(TotalList totallist); // 리스트 추가
	public void updateList(TotalList totallist); // 리스트 업데이트
	public void deleteList(int no); // 리스트 삭제
	public TotalList foodsearch(TotalList totallist); // food 정보 가져오기
	public List<Integer> bestfood();
}