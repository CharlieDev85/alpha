package com.green.alpha.dto;

import com.green.alpha.model.Answer;
import com.green.alpha.model.User;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class AnswerUserDTO {
    private Long id;
    private AnswerDTO answerDTO;
    private UserDTO userDTO;
    private boolean selected;
}
