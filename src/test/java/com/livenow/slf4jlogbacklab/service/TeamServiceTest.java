package com.livenow.slf4jlogbacklab.service;

import com.livenow.slf4jlogbacklab.domain.Member;
import com.livenow.slf4jlogbacklab.domain.MemberRepository;
import com.livenow.slf4jlogbacklab.domain.Team;
import com.livenow.slf4jlogbacklab.domain.TeamRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("Team 비즈니스 흐름 테스트")
class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MemberRepository memberRepository;

    private Member member;
    private Team team;

    @BeforeEach
    void init() {
        member = new Member("성실한 직원", 27);
        team = new Team("좋은 팀");
        memberRepository.save(member);
        teamRepository.save(team);
    }

    @AfterEach
    void clear() {
        memberRepository.deleteAll();
        teamRepository.deleteAll();
    }

    @DisplayName("멤버 추가 - 성공")
    @Test
    @Transactional
    void addMember() {
        //given
        //when
        teamService.addMember("좋은 팀", "성실한 직원");
        Team findTeam = teamRepository.findByName("좋은 팀").get();
        //then
        assertThat(findTeam.getMembers()).contains(member);
    }
}