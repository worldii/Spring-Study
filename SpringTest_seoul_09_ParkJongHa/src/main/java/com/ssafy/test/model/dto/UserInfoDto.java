package com.ssafy.test.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoDto {
	private String userId;
	private String userPw;
	private String position;
	private String name;
	private String rName;
	private int rClass;
}
