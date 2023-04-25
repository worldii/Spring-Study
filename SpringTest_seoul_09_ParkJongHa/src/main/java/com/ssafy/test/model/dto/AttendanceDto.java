package com.ssafy.test.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceDto {
	private String ano;
	private String userId;
	private String issuedate;
	private String issue;
}
