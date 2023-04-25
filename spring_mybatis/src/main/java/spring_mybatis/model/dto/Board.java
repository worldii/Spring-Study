package spring_mybatis.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {

	private int articleNo;
	private String userId;
	private String subject;
	private String content;
	private int hit;
	private Date registerTime;
	private Member member;
}
