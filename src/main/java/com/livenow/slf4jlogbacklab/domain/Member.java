package com.livenow.slf4jlogbacklab.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    private String name;
    private int age;

    protected Member() {
    }

    public Member(String name, int age) {
        this(null, name, age);
    }

    public Member(Team team, String name, int age) {
        this(null, team, name, age);
    }

    public Member(Long id, Team team, String name, int age) {
        this.id = id;
        this.team = team;
        this.name = name;
        this.age = age;
    }

    public void changeTeam(Team team) {
        if (Objects.nonNull(this.team)) {
            this.team.getMembers().remove(this);
        }
        this.team = team;
        team.getMembers().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
