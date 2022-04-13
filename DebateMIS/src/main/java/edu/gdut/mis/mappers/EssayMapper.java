package edu.gdut.mis.mappers;

import edu.gdut.mis.entity.Essay;

import java.util.List;

public interface EssayMapper {

    public void insertEssay(Essay essay);

    List<Essay> getEssayByDebateId(Integer debateId);

    Essay getEssayByEssayId(Integer essayId);

    Integer getNol(Integer essayId);

    void updateNol(Integer essayId);

    List<Essay> showHotEssay();
}
