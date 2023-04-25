package spring_mybatis.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Member {
	private String userId;
	private String userName;
	private String userPwd;
	private String emailId;
	private String emailDomain;
	private String joinDate;

	private List<Board> boards;
}
