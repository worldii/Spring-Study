package com.example.springjpapractice.service;

import com.example.springjpapractice.domain.Member;
import com.example.springjpapractice.repository.MemberRepository;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;
    @Test
    @DisplayName("회원가입")
    public void join() {
        // given
        Member member = new Member();
        member.setName("kim");

        // when
        Long id = memberService.join(member);
        em.flush();

        // then
        Assert.assertEquals(member, memberRepository.findOne(id));
    }
}