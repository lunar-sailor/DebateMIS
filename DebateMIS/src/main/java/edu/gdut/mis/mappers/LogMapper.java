package edu.gdut.mis.mappers;

import edu.gdut.mis.entity.Debater;

public interface LogMapper {
    String getPasswordById(Integer debateId);

    Debater getDebaterById(Integer debateId);
}
