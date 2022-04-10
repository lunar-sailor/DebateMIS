package edu.gdut.mis.service;

import edu.gdut.mis.entity.DebateTeam;
import edu.gdut.mis.mappers.DebateTeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    DebateTeamMapper teamMapper;

    public int insertTeam(DebateTeam debateTeam) {
        teamMapper.insertDebateTeam(debateTeam);
        int teamId = debateTeam.getTeamId();
        return teamId;
    }

    public List<DebateTeam> getTeamById(int teamId) {
        List<DebateTeam> list = teamMapper.getDebateTeamById(teamId);
        return list;
    }

    public List getTeamByName(String teamName) {
        List<DebateTeam> list = teamMapper.getDebateTeamByName(teamName);
        return list;
    }

    public List<DebateTeam> getTeamByUniversity(String university) {
        List<DebateTeam> list = teamMapper.getDebateTeamByUniversity(university);
        return list;
    }
}
