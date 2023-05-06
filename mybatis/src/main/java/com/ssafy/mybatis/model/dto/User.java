package com.ssafy.mybatis.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String id;
	private String name;
	private String pass;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}

}
