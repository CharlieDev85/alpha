package com.green.alpha.service;

import com.green.alpha.dto.QuestionDTO;
import com.green.alpha.mapper.QuestionMapper;
import com.green.alpha.model.Answer;
import com.green.alpha.model.Question;
import com.green.alpha.repository.AnswerRepository;
import com.green.alpha.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }


    public QuestionDTO save (QuestionDTO questionDTO){
        Question question = QuestionMapper.INSTANCE.toEntity(questionDTO);
        Question questionSaved = questionRepository.save(question);
        QuestionDTO savedQuestionDTO = QuestionMapper.INSTANCE.toDTO(questionSaved);
        return savedQuestionDTO;
    }

    public QuestionDTO findById(Long id){
        Optional<Question> question = questionRepository.findById(id);
        //question.get().getAnswers().size();
        QuestionDTO questionDTO = QuestionMapper.INSTANCE.toDTO(question.get());
        return questionDTO;
    }

}
