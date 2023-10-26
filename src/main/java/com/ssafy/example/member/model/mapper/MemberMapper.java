package com.ssafy.example.member.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.example.member.model.dto.Member;

@Mapper
public interface MemberMapper {
	int addMember(Member member);
	
	List<Member> memberList();
	
	Member memberDetail(String id);
	
	int updateMember(Member member);
	
	int deleteMember(String id);
}
