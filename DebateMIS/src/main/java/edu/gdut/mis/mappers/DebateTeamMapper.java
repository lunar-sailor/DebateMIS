package edu.gdut.mis.mappers;

import edu.gdut.mis.entity.DebateTeam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DebateTeamMapper {

    //新建辩论队
    void insertDebateTeam(@Param("debateTeam")DebateTeam debateTeam);

    //通过队名搜索辩论队
    List<DebateTeam> getDebateTeamByName(@Param("teamName")String teamName);

    //通过学校搜索辩论队
    List<DebateTeam> getDebateTeamByUniversity(@Param("teamName")String university);
    
    //通过队伍ID搜索辩论队
    List<DebateTeam> getDebateTeamById(@Param("teamId")Integer teamId);
}
