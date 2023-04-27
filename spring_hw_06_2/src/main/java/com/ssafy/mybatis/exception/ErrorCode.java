package com.ssafy.mybatis.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "E001", "내부 서버 오류입니다."),
    METHOD_NOT_ALLOWED(405, "E002", "허용되지 않은 HTTP method입니다."),
    RUNTIME_EXCEPTION(400, "E003", "유효하지 않은 입력입니다."),
    ACCESS_DENIED_EXCEPTION(401, "E004", "권한이 없습니다.");
    private final int status;
    private final String code;
    private final String message;
}