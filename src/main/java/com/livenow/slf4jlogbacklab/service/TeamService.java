package com.livenow.slf4jlogbacklab.service;

import com.livenow.slf4jlogbacklab.common.NotFoundException;
import com.livenow.slf4jlogbacklab.domain.Member;
import com.livenow.slf4jlogbacklab.domain.MemberRepository;
import com.livenow.slf4jlogbacklab.domain.Team;
import com.livenow.slf4jlogbacklab.domain.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TeamService {

    private Logger logger = LoggerFactory.getLogger(TeamService.class);

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
        Team team = findTeam(teamName);
        Member member = findMember(memberName);
        team.addMember(member);
    }

    private Member findMember(String memberName) {
        Optional<Member> member = memberRepository.findByName(memberName);
        if (member.isEmpty()) {
            String detailMessage = String.format("NotFoundException: Cannot find Member by input value, Input: %s", memberName);
            logger.info(detailMessage);
            throw new NotFoundException(detailMessage);
        }
        return member.get();
    }

    private Team findTeam(String teamName) {
        Optional<Team> team = teamRepository.findByName(teamName);
        if (team.isEmpty()) {
            String detailMessage = String.format("NotFoundException: Cannot find Team by input value. Input: %s", teamName);
            logger.info(detailMessage);
            throw new NotFoundException(detailMessage);
        }
        return team.get();
    }
}
