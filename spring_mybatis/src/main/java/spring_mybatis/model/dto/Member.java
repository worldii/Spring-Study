package spring_mybatis.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Member {
	String userId;
	String userName;
	String userPwd;
	String emailId;
	String emailDomain;
	String joinDate;
}
