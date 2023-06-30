package com.example.springjpapractice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "member")
@Getter
@Setter
public class Member {
    public Member() {}
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;

    @Embedded
    private Address address;


}
