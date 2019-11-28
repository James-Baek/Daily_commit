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

import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.QnA;
import com.ssafy.model.dto.Result;
import com.ssafy.model.service.QnAService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @RestController
 * REST Ful 서비스를 위한 컨트롤러로 @ResponseBody 어노테이션을 추가하지 않아도
 * 기본적으로 직접 출력 해 준다.
 * 
 */
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/qna")
@RestController
@Api("TodoList Rest API")
public class QnARestController {
	@Autowired
	private QnAService service;
//	
//	@ExceptionHandler
//	public ResponseEntity<Map<String, Object>> handle(Exception e){
//		return handleFail(e.getMessage(), HttpStatus.OK);
//	}
	@ApiOperation("qna 검색 기능, key = 조회 조건(name, title, content), word = 검색할 단어, pageNo = 현재 페이지 번호")
	@GetMapping("/search/{key}/{word}/{pageNo}")
	public ResponseEntity<List<QnA>> search(@PathVariable String key, @PathVariable String word, @PathVariable String pageNo){
		PageBean bean = new PageBean(key, word, pageNo);
		List<QnA> qnaList = service.search(bean);
		if (qnaList.size() > 0) {
			return new ResponseEntity<List<QnA>>(qnaList, HttpStatus.OK);
		}
		return new ResponseEntity<List<QnA>>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation("전체 qna목록을 조회하는 기능")
	@GetMapping("/qnaList")
	public ResponseEntity<List<QnA>> qnaList(){
		List<QnA> qnaList = service.getQnAList();
		System.out.println("컨트롤러 가져옴");
		if (qnaList.size() > 0) {
			return new ResponseEntity<List<QnA>>(qnaList, HttpStatus.OK);
		}
		return new ResponseEntity<List<QnA>>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="등록된 QnA 상세 내역을 조회한다.", response=QnA.class)
	@GetMapping("/detail/{no}")
	public ResponseEntity<QnA> findQnA(@PathVariable int no){
		QnA qna = service.selectOne(no+"");
		if(qna != null) {
			return new ResponseEntity<QnA>(qna, HttpStatus.OK);
		}
		return new ResponseEntity<QnA>(HttpStatus.NO_CONTENT);
	}

	
	@ApiOperation(value="등록되어 있는 QnA를 삭제한다.", response=Result.class)
	@DeleteMapping("/todo/{no}")
	public ResponseEntity<Result> deleteQnA(@PathVariable int no) {
		service.delete(no+"");
		return new ResponseEntity<Result>(new Result(true, "삭제 성공"), HttpStatus.OK);
	}
	
	@ApiOperation(value="QnA를 등록한다.")
	@PostMapping("/add")
	public ResponseEntity<Result> addQnA(@RequestBody QnA qna){
		service.add(qna);
		return new ResponseEntity<Result>(new Result(true, "등록 완료"), HttpStatus.OK);
	}

	@ApiOperation(value="QnA 정보 수정")
	@PutMapping("/update/{no}")
	public ResponseEntity<Result> updateQnA(@PathVariable int no, @RequestBody QnA qna){
		QnA q = qna;
		if(!q.getComment().equals(""))q.setDone('Y');
		else q.setDone('N');
		service.update(q);
		return new ResponseEntity<Result>(new Result(true, "수정 완료"), HttpStatus.OK);
	}
//	
//	public ResponseEntity<Map<String, Object>> handleFail(Object data, HttpStatus state){
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("state",  "fail");
//		resultMap.put("data", data);
//		return new ResponseEntity<Map<String, Object>>(resultMap, state);
//	}
//	
//	public ResponseEntity<Map<String, Object>> handleSuccess(Object data){
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("state",  "ok");
//		resultMap.put("data", data);
//		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
//	}
}
