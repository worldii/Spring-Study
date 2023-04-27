package com.ssafy.mybatis.api;

import com.ssafy.mybatis.model.dto.ResultCode;
import com.ssafy.mybatis.model.dto.ResultResponse;
import com.ssafy.mybatis.model.dto.User;
import com.ssafy.mybatis.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<ResultResponse> login(@RequestBody User user) {
        User result = userService.join(user);
        if (result == null) throw new RuntimeException();
        else return ResponseEntity.ok(new ResultResponse(ResultCode.LOGIN_SUCCESS, result));
    }

    @GetMapping("/logout")
    public ResponseEntity<ResultResponse> doLogout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok(new ResultResponse(ResultCode.LOGOUT_SUCCESS, true));
    }
}
