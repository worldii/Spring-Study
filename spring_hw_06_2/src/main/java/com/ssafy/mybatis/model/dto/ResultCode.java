package com.ssafy.mybatis.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
	// COMMENT
	LOGIN_SUCCESS(200, "U001", "로그인에 성공하였습니다."),
	LOGOUT_SUCCESS(200, "U002", "로그아웃에 성공하였습니다."),

	DELETE_BOOK_SUCCESS(200, "B001", "책 삭제에 성공하였습니다."),
	GET_BOOKS_SUCCESS(200, "B002", "책 목록 조회에 성공하였습니다."),
	UPDATE_BOOK_SUCCESS(200, "B003", "댓글 수정에 성공하였습니다."),
	GET_BOOK_SUCCESS(200, "B004", "책 조회에 성공하였습니다."),
	REGISTER_BOOK_SUCCESS(200, "B004", "책 등록에 성공하였습니다.");

	private final int status;
	private final String code;
	private final String message;

}