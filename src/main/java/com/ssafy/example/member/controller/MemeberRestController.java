package com.ssafy.example.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ssafy.example.member.model.service.MemberService;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class MemeberRestController {
	@Autowired
	MemberService memberService;
	
	@Autowired // 다른 url 요청보낼때
	RestTemplate template;
	
	@GetMapping("/{userId}") // request body가 form인경우에는 @ModelAttribute
	public ResponseEntity<Map<String, Object>> isUserExist(@PathVariable String userId) {
		return handleSuccess(memberService.idCheck(userId));
	}
		
	// responsebody 성공
	private ResponseEntity<Map<String, Object>> handleSuccess(Object data) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("success", true);
		resultMap.put("data", data);
		return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK);
	}
	
	// responsebody 실패
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> exceptionHandler(Exception e) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("success", false);
		resultMap.put("data", e.getMessage());
		return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
