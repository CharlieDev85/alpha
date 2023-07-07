package com.green.alpha.model;

import lombok.Data;

@Data
public class AnsweredQuiz {
    private Long id;
    private User user;
    private Quiz quiz;
    private Double score;
}
