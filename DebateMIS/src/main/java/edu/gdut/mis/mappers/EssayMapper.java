package edu.gdut.mis.mappers;

import edu.gdut.mis.entity.Essay;

import java.util.List;

public interface EssayMapper {

    public void insertEssay(Essay essay);

    List<Essay> getEssayById(Integer debateId);
}
