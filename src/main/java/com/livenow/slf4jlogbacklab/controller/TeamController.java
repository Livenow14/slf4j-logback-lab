package com.livenow.slf4jlogbacklab.controller;

import com.livenow.slf4jlogbacklab.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{name}")
    public void save(@PathVariable String name) {
        teamService.save(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{teamName}/members/{memberName}")
    public void addMember(@PathVariable String teamName, @PathVariable String memberName) {
        teamService.addMember(teamName, memberName);
    }
}
