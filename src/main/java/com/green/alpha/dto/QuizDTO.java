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

}
