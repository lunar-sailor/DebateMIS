package edu.gdut.mis.service;

import edu.gdut.mis.entity.Debater;
import edu.gdut.mis.mappers.DebaterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebaterService {
    @Autowired
    DebaterMapper debaterMapper;

    public int insertDebater(Debater debater) {
        debaterMapper.insertDebater(debater);
        int debateId = debater.getDebateId();
        return debateId;
    }

    public Debater getDebaterById(Integer debateId) {
        Debater debater = debaterMapper.getDebaterById(debateId);
        return debater;
    }

    public List<Debater> getAllDebater() {
        List<Debater> list = debaterMapper.getAllDebater();
        return list;
    }
}
