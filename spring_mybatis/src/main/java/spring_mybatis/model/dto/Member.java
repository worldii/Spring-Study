package spring_mybatis.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {
	String userId;
	String userName;
	String userPwd;
	String emailId;
	String emailDomain;
	String joinDate;
	
}
