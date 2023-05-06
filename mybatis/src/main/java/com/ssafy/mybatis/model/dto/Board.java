package com.ssafy.mybatis.model.dto;

import lombok.*;

import java.sql.Date;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int articleNo;
    private String userId;
    private String subject;
    private String content;
    private int hit;
    private Date registerTime;
    private Member member;
}
