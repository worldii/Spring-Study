package com.ssafy.test.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.test.model.dto.AttendanceDto;
import com.ssafy.test.model.repo.AttendanceRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

	private final AttendanceRepo attendanceRepo;
	
	@Override
	public int regist(AttendanceDto attendanceDto) throws SQLException {
		// TODO Auto-generated method stub
		return attendanceRepo.regist(attendanceDto);
	}

	@Override
	public List<AttendanceDto> select() throws SQLException {
		// TODO Auto-generated method stub
		return attendanceRepo.select();
	}

	@Override
	public int delete(String ano) throws SQLException {
		// TODO Auto-generated method stub
		return attendanceRepo.delete(ano);
	}

	@Override
	public AttendanceDto getAttendanceDto(String ano) throws SQLException {
		// TODO Auto-generated method stub
		return attendanceRepo.getAttendanceDto(ano);
	}

}
