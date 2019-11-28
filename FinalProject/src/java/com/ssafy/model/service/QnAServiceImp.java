package com.ssafy.model.service;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.QnADAO;
import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.QnA;
import com.ssafy.model.dto.QnAException;
import com.ssafy.util.PageUtility;

@Service
public class QnAServiceImp implements QnAService {

	@Autowired
	private QnADAO dao;
	
	public QnAServiceImp() {}
	
	public QnADAO getDao() {
		return dao;
	}

	public void setDao(QnADAO dao) {
		this.dao = dao;
	}

	public List<QnA> search(PageBean bean){
		try {
			int total = dao.count(bean);
			PageUtility bar = new PageUtility(bean.getInterval()
											, total
											, bean.getPageNo()
											, "/images/");
			bean.setPageLink(bar.getPageBar());
			return dao.search(bean);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new QnAException();
		}
	}
	public List<QnA> getQnAList(){
		try {
			return dao.getQnAList();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new QnAException();
		}
	}

	public QnA selectOne(String no) {
		try {
			QnA qna = dao.selectOne(no);
			if(qna == null) {
				throw new QnAException("없는 게시물 입니다.");
			}else {
				System.out.println("요청한 게시물");
				return qna;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new QnAException();
		}
	}

	public void add(QnA qna) {
		try {
			dao.add(qna);
		}catch(SQLException e) {
			e.printStackTrace();
			throw new QnAException();
		}
	}

	public void update(QnA qna) {
		try {
			QnA find = dao.selectOne(qna.getNo()+"");
			if(find == null) {
				throw new QnAException();
			}else {
				dao.update(qna);
			}
		} catch(SQLException e) {
			throw new QnAException();
		}
	}

	public void delete(String no) {
		try {
			QnA find = dao.selectOne(no);
			if(find == null) {
				throw new QnAException("없는 게시물 입니다.");
			}else {
				dao.delete(no);
			}
		}catch (SQLException e) {
			throw new QnAException();
		}
	}

}
