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

    public List<Essay> getEssayById(Integer debateId) {
        List<Essay> list = essayMapper.getEssayById(debateId);
        return list;
    }
}
