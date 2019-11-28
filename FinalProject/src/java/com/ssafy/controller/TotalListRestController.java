package com.ssafy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.Codemap;
import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.QnA;
import com.ssafy.model.dto.Result;
import com.ssafy.model.dto.TotalList;
import com.ssafy.model.service.CodemapService;
import com.ssafy.model.service.TotalListService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/totallist")
@RestController
@Api("Codemap Rest API")
public class TotalListRestController {
	
	@Autowired
	private TotalListService totalService;
	@Autowired
	private CodemapService codeService;
	
	@ApiOperation("code = A01 섭취, A02 찜    id = 유저id 넣고 기간 상관없이 전체 다 가져오는 기능")
	@GetMapping("/searchByCondition/{code}/{id}/{pageNo}")
	public ResponseEntity<List<TotalList>> searchByCondition(@PathVariable String code, @PathVariable String id, @PathVariable String pageNo){
		PageBean bean = new PageBean(code, id, pageNo);
		List<TotalList> totalList = totalService.searchByCondition(bean);
		if (totalList.size() > 0) {
			return new ResponseEntity<List<TotalList>>(totalList, HttpStatus.OK);
		}
		return new ResponseEntity<List<TotalList>>(HttpStatus.NO_CONTENT);
	}
	

	
	@ApiOperation(value="TotalList를 등록한다.")
	@PostMapping("/add")
	public ResponseEntity<Result> addQnA(@RequestBody TotalList totallist){
		totalService.addList(totallist);
		return new ResponseEntity<Result>(new Result(true, "등록 완료"), HttpStatus.OK);
	}

	@ApiOperation(value="TotalList 정보 수정")
	@PutMapping("/update/{no}")
	public ResponseEntity<Result> updateQnA(@PathVariable int no, @RequestBody TotalList totallist){
		totallist.setNo(no);
		totalService.updateList(totallist);
		return new ResponseEntity<Result>(new Result(true, "수정 완료"), HttpStatus.OK);
	}
	
	@ApiOperation(value="등록되어 있는 TotalList를 삭제한다.", response=Result.class)
	@DeleteMapping("/delete/{no}")
	public ResponseEntity<Result> deleteQnA(@PathVariable int no) {
		totalService.deleteList(no);
		return new ResponseEntity<Result>(new Result(true, "삭제 성공"), HttpStatus.OK);
	}
}
