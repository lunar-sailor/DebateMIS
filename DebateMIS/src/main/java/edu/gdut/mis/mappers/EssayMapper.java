package edu.gdut.mis.mappers;

import edu.gdut.mis.entity.Essay;
import edu.gdut.mis.entity.Record;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EssayMapper {

    public void insertEssay(Essay essay);

    List<Essay> getEssayByDebateId(Integer debateId);

    Essay getEssayByEssayId(Integer essayId);

    Integer getNol(Integer essayId);

    void updateNol(Integer essayId);

    void insertLike_Record(@Param("essayId") Integer essayId,@Param("debateId")Integer debateId);

    int hasLiked(@Param("essayId") Integer essayId, @Param("debateId") Integer debateId);

    List<Essay> showHotEssay();
}
