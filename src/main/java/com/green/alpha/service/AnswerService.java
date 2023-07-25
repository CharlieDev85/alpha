package com.green.alpha.service;

import com.green.alpha.mapper.AnswerMapper;
import com.green.alpha.model.Answer;
import com.green.alpha.dto.AnswerDTO;
import com.green.alpha.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public AnswerDTO save(AnswerDTO answerDTO){
        Answer answer = AnswerMapper.INSTANCE.answerDTOToAnswer(answerDTO);
        Answer createdAnswer = answerRepository.save(answer);
        return AnswerMapper.INSTANCE.answerToAnswerDTO(createdAnswer);
    }
}
