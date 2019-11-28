package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.QnA;

@Mapper
public interface QnADAO {
	public List<QnA> search(PageBean bean) throws SQLException; // 특정 조건 QnA 검색
	public List<QnA> getQnAList() throws SQLException;
	public QnA selectOne(String no) throws SQLException;
	public void add(QnA qna) throws SQLException;
	public void update(QnA qna) throws SQLException;
	public void delete(String no) throws SQLException;
	public int count(PageBean bean) throws SQLException;
}
