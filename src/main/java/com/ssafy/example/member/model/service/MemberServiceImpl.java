package com.ssafy.example.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.example.member.model.dto.Member;
import com.ssafy.example.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public void addMember(Member member) {
		memberMapper.addMember(member);
	}

	@Override
	public Member memberDetail(String id) {
		return memberMapper.memberDetail(id);
	}

}
