package edu.gdut.mis.service;

import edu.gdut.mis.entity.Essay;
import edu.gdut.mis.entity.Record;
import edu.gdut.mis.mappers.EssayMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EssayService {

    @Autowired
    EssayMapper essayMapper;

    public void insertEssay(Essay essay){
        essayMapper.insertEssay(essay);
    }

    public List<Essay> getEssayByDebateId(Integer debateId) {
        List<Essay> list = essayMapper.getEssayByDebateId(debateId);
        return list;
    }

    public Essay getEssayByEssayId(Integer essayId) {
        Essay essay = essayMapper.getEssayByEssayId(essayId);
        return essay;
    }

    public Integer getNol(Integer essayId){
        Integer nol = essayMapper.getNol(essayId);
        return nol;
    }

    public void updateNol(Integer essayId){
            essayMapper.updateNol(essayId);
    }

    public Boolean hasLiked(@Param("essayId") Integer essayId, @Param("debateId") Integer debateId){
        int num = essayMapper.hasLiked(essayId,debateId);
        if (num > 0){
            return true;
        }
        return false;
    }

    public void insertLike_Record(@Param("debateId")Integer essayId,@Param("debateId")Integer debateId){
        essayMapper.insertLike_Record(essayId,debateId);
    }

    public List<Essay> showHotEssay() {
        List<Essay> list = essayMapper.showHotEssay();
        return list;
    }
}
