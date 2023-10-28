package com.ssafy.example.member.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.example.member.model.dto.Member;

@Mapper
public interface MemberMapper {
	int addMember(Member member);
	
	List<Member> memberList();
	
	Member memberDetail(String id);
	
	int updateMember(Member member);
	
	int deleteMember(String id);
	
	Member loginUser(Map<String, String> map);
	
	int idCheck(String userId);
}
