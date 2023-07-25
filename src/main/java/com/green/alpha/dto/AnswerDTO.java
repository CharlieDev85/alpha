package com.green.alpha.dto;


import com.green.alpha.model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {

    private Long id;
    private String text;
    private boolean correct;
    private QuestionDTO questionDTO;

    public AnswerDTO (String text, boolean correct,QuestionDTO questionDTO){
        this.text = text;
        this.correct = correct;
        this.questionDTO = questionDTO;
    }
    public AnswerDTO (String text, boolean correct){
        this.text = text;
        this.correct = correct;
    }
}
