package com.example.springjpapractice.service;

import com.example.springjpapractice.domain.Member;
import com.example.springjpapractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public long save(Member member) {
        memberRepository.save(member);
        return member.getId();
    }
    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public List<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }

    @Transactional
    public Long join (Member member) {
        memberRepository.save(member);
        return member.getId();
    }
}
