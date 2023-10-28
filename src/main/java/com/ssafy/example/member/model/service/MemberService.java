package com.ssafy.example.member.model.service;

import java.util.Map;

import com.ssafy.example.member.model.dto.Member;

public interface MemberService {
	void addMember(Member member);
	
	Member memberDetail(String id);
	
	Member login(Map<String, String> map);
	
	int idCheck(String userId);
}
