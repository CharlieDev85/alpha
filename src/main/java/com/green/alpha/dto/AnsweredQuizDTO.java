package com.green.alpha.dto;

import lombok.Data;

@Data
public class AnsweredQuizDTO {
    private Long id;
    private UserDTO userDTO;
    private QuizDTO quizDTO;
    private Double score;
}
