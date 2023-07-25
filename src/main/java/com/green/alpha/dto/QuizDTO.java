package com.green.alpha.dto;

import lombok.Data;

import java.util.List;
@Data
public class QuizDTO {

    private Long id;
    private UserDTO creator;
    private String title;
    private String instructions;
    private Double maxScore;
    private List<QuestionDTO> questionsDTO;

    public QuizDTO(){}

    public QuizDTO (UserDTO creator, String title, String instructions, Double maxScore, List<QuestionDTO> questionsDTO){
        this.creator = creator;
        this.title = title;
        this.instructions = instructions;
        this.maxScore = maxScore;
        this.questionsDTO = questionsDTO;
    }

}
