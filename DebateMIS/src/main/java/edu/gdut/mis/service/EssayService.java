package edu.gdut.mis.service;

import edu.gdut.mis.entity.Essay;
import edu.gdut.mis.mappers.EssayMapper;
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
        return essayId;
    }

    public Integer updateNol(Integer essayId){
        essayMapper.updateNol(essayId);
        Integer nol = essayMapper.getNol(essayId);
        return nol;
    }

    public List<Essay> showHotEssay() {
        List<Essay> list = essayMapper.showHotEssay();
        return list;
    }
}
