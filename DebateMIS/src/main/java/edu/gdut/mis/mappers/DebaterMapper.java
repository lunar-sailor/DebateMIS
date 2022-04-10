package edu.gdut.mis.mappers;

import edu.gdut.mis.entity.Debater;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DebaterMapper {
    int insertDebater(Debater debater);

    void updateDebater();

    void deleteDebater();

    Debater getDebaterById(@Param("debateId") Integer debateId);

    String getUsernameById(@Param("username") String username);

    List<Debater> getAllDebater();
}
