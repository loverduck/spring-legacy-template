package com.ssafy.example.product.model.dto;

import com.ssafy.example.member.model.dto.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	@NonNull
	private String code;
	@NonNull
	private String model;
	@NonNull
	private String price;
	@NonNull
	private String id; // 등록 유저 아이디
	
	private Member member;
}
