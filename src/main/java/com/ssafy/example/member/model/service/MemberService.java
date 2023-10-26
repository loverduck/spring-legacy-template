package com.ssafy.example.member.model.service;

import com.ssafy.example.member.model.dto.Member;

public interface MemberService {
	void addMember(Member member);
	
	Member memberDetail(String id);
}
