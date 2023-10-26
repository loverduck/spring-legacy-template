package com.ssafy.example.member.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Member {
	@NonNull
	private String id;
	@NonNull
	private String name;
	@NonNull
	private String password;
	private Date joinDate;
}
