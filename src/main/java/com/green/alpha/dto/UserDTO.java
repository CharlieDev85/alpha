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


    public UserDTO(){}

    public UserDTO(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
