package com.livenow.slf4jlogbacklab.service;

import com.livenow.slf4jlogbacklab.domain.Member;
import com.livenow.slf4jlogbacklab.domain.MemberRepository;
import com.livenow.slf4jlogbacklab.domain.Team;
import com.livenow.slf4jlogbacklab.domain.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public TeamService(MemberRepository memberRepository, TeamRepository teamRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void save(String name) {
        Team team = new Team(name);
        teamRepository.save(team);
    }

    @Transactional
    public void addMember(String teamName, String memberName) {
        Team team = teamRepository.findByName(teamName)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 팀입니다."));
        Member member = memberRepository.findByName(memberName)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 직원입니다."));
        team.addMember(member);
    }
}
