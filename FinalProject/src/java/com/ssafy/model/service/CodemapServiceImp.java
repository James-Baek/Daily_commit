package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.CodemapDAO;
import com.ssafy.model.dto.Codemap;
import com.ssafy.model.dto.CodemapException;

@Service
public class CodemapServiceImp implements CodemapService {
	
	@Autowired
	CodemapDAO dao;
	
	public CodemapServiceImp() {};
	public CodemapServiceImp(CodemapDAO dao) {
		super();
		this.dao = dao;
	}
	
	public CodemapDAO getDao() {
		return dao;
	}
	
	public void setDao(CodemapDAO dao) {
		this.dao = dao;
	}
	
	public String searchCode(String code) {
		try {
			return dao.searchCode(code);
		}catch(Exception e) {
			e.printStackTrace();
			throw new CodemapException();
		}
	}

	public List<Codemap> getAllCode() {
		try {
			System.out.println("야!!!!!!!!!!!");
			List<Codemap> temp = dao.getAllCode();
			System.out.println(temp);
			return temp;
		}catch(Exception e) {
			e.printStackTrace();
			throw new CodemapException();
		}
	}

}
