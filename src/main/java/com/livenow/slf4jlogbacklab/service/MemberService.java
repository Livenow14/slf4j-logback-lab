package com.livenow.slf4jlogbacklab.service;

import com.livenow.slf4jlogbacklab.controller.dto.MemberRequest;
import com.livenow.slf4jlogbacklab.domain.Member;
import com.livenow.slf4jlogbacklab.domain.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void save(MemberRequest memberRequest) {
        Member member = memberRequest.toEntity();
        memberRepository.save(member);
    }
}
