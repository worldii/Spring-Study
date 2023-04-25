package com.ssafy.test.model.repo;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.test.model.dto.AttendanceDto;
import com.ssafy.util.DBUtil;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AttendanceRepoImpl implements AttendanceRepo {
	
	private final DataSource ds;
	private final DBUtil util;
	
	@Override
	public int regist(AttendanceDto attendanceDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AttendanceDto> select() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String ano) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AttendanceDto getAttendanceDto(String ano) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
