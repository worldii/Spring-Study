package com.ssafy.test.model.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.model.dto.AttendanceDto;

public interface AttendanceRepo {
	int regist(AttendanceDto attendanceDto) throws SQLException;
	List<AttendanceDto> select() throws SQLException;
	int delete (String ano) throws SQLException;
	AttendanceDto getAttendanceDto (String ano) throws SQLException;
}
