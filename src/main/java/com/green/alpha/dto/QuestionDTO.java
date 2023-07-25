package com.green.alpha.dto;

import lombok.Data;

import java.util.List;
@Data
public class QuestionDTO {
    private Long id;
    private String text;
    private List<AnswerDTO> answersDTO;
    private QuizDTO quizDTO;

    public QuestionDTO (String text, List<AnswerDTO> answersDTO){
        this.text = text;
        this.answersDTO = answersDTO;
    }
    public QuestionDTO (){}

}
