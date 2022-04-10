package edu.gdut.mis.service;

import edu.gdut.mis.entity.Debater;
import edu.gdut.mis.mappers.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    @Autowired
    LogMapper mapper;

    public String getPasswordById(Integer debateId){
        String password = mapper.getPasswordById(debateId);
        return password;
    }

    public Debater getDebaterById(Integer debateId){
        Debater debater = mapper.getDebaterById(debateId);
        return debater;
    }
}
