package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.QnA;

public interface QnAService {
	public List<QnA> search(PageBean bean);
	public List<QnA> getQnAList();
	public QnA selectOne(String no);
	public void add(QnA qna);
	public void update(QnA qna);
	public void delete(String no);
}
