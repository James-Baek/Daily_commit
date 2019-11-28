package com.ssafy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.Codemap;
import com.ssafy.model.service.CodemapService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/codemap")
@RestController
@Api("Codemap Rest API")
public class CodemapRestController {
	
	@Autowired
	private CodemapService codeService;
	
	@ApiOperation("code로 찜인지 뭔지 찾는 것")
	@GetMapping("/search/{code}")
	public ResponseEntity<String> search(@PathVariable String code){
		
		String text = codeService.searchCode(code);
		
		if (text != "") {
			return new ResponseEntity<String>(text, HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation("code 전체 가져오기")
	@GetMapping("/getAllCode")
	public ResponseEntity<List<Codemap>> getAllCode(){
		
		List<Codemap> codelist = codeService.getAllCode();
		
		if (codelist.size() > 0) {
			return new ResponseEntity<List<Codemap>>(codelist, HttpStatus.OK);
		}
		return new ResponseEntity<List<Codemap>>(HttpStatus.NO_CONTENT);
	}
	
}
