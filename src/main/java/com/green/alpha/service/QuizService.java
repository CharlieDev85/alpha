package com.green.alpha.service;


import com.green.alpha.dto.QuizDTO;
import com.green.alpha.mapper.QuizMapper;
import com.green.alpha.model.Quiz;
import com.green.alpha.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public QuizDTO save(QuizDTO quizDTO){
        //Mapper is bringing quiz's questions but not their answers
        Quiz quiz = QuizMapper.INSTANCE.toEntity(quizDTO);
        Quiz savedQuiz = quizRepository.save(quiz);
        QuizDTO savedQuizDTO = QuizMapper.INSTANCE.toDto(savedQuiz);
        return savedQuizDTO;
    }

    public QuizDTO findById(Long id){
        Quiz quiz = quizRepository.findById(id).get();
        return QuizMapper.INSTANCE.toDto(quiz);
    }

}
