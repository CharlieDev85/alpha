package com.green.alpha.controller;

import com.green.alpha.dto.AnswerDTO;
import com.green.alpha.dto.QuestionDTO;
import com.green.alpha.model.Answer;
import com.green.alpha.model.Question;
import com.green.alpha.repository.QuestionRepository;
import com.green.alpha.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class GeneralController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/index")
    public String index() {Question question = new Question();
        question.setText("She is __ doctor");
        Answer answer1 = new Answer();
        answer1.setText("a");
        answer1.setCorrect(true);
        Answer answer2 = new Answer();
        answer2.setText("an");
        answer2.setCorrect(false);
        question.setAnswers(List.of(answer1,answer2));
        Question questionSaved = questionRepository.save(question);
        System.out.println(questionSaved);
        Question questionRecovered = questionRepository.findById(questionSaved.getId()).get();
        System.out.println(questionRecovered);
        System.out.println(questionRecovered.getAnswers());

        return "hello";

    }

}
