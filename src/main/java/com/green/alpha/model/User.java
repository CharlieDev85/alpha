package com.green.alpha.model;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Quiz> createdQuizzes;
    private List<AnsweredQuiz> answeredQuizzes;

}
