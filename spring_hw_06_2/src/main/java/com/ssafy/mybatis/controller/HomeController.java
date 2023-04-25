package com.ssafy.mybatis.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping({ "/", "/index"  })
    public String showRoot() {
        return "index";
    }

}
