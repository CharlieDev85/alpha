package com.green.alpha.service;

import com.green.alpha.model.AnswerUser;
import com.green.alpha.repository.AnswerUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizUserService {

    private final AnswerUserRepository answerUserRepository;

    public QuizUserService(AnswerUserRepository answerUserRepository) {
        this.answerUserRepository = answerUserRepository;
    }


}
