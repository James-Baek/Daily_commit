package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.TotalListDAO;
import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.TotalList;
import com.ssafy.model.dto.TotalListException;
import com.ssafy.util.PageUtility;

@Service
public class TotalListServiceImp implements TotalListService {
	
	@Autowired
	TotalListDAO dao;
	
	public TotalListServiceImp() {};
	public TotalListServiceImp(TotalListDAO dao) {
		super();
		this.dao = dao;
	}
	public TotalListDAO getDao() {
		return dao;
	}
	public void setDao(TotalListDAO dao) {
		this.dao = dao;
	}
	
	public List<TotalList> searchByCondition(PageBean bean) {
		try {
			int total = dao.count(bean);
			PageUtility bar = new PageUtility(bean.getInterval()
											, total
											, bean.getPageNo()
											, "/images/");
			bean.setPageLink(bar.getPageBar());
			return dao.searchByCondition(bean);
		}catch(SQLException e) {
			e.printStackTrace();
			throw new TotalListException();
		}
	}
	public TotalList isUnique(TotalList totallist) {
		try {
			TotalList ans = dao.isUnique(totallist);
			System.out.println("dao : "+totallist);
			System.out.println("ans : "+ans);
			if(ans == null) {
				return null;
			}
			return ans;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new TotalListException();
		}
	}
	
	public void addList(TotalList totallist) {
		try {
				dao.addList(totallist);
		}catch(SQLException e) {
			e.printStackTrace();
			throw new TotalListException();
		}
	}

	public void updateList(TotalList totallist) {
		try {
			dao.updateList(totallist);
		}catch(SQLException e) {
			e.printStackTrace();
			throw new TotalListException();
		}
	}

	public void deleteList(int no) {
		try {
			dao.deleteList(no);
		}catch(SQLException e) {
			e.printStackTrace();
			throw new TotalListException();
		}
	}
	public TotalList foodsearch(TotalList totallist) {
		try {
			return dao.foodsearch(totallist);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TotalListException();
		}
	}
	public List<Integer> bestfood() {
		try {
			return dao.bestfood();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new TotalListException();
		}
	}

}
