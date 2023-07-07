package com.green.alpha.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<QuizDTO> createdQuizzesDTO;
    private List<AnsweredQuizDTO> answeredQuizzesDTO;

}
