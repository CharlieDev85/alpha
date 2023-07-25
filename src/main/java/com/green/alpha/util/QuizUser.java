package com.green.alpha.util;

import com.green.alpha.dto.QuizDTO;
import com.green.alpha.dto.UserDTO;
import com.green.alpha.mapper.AnswerMapper;
import com.green.alpha.mapper.UserMapper;
import com.green.alpha.model.AnswerUser;
import com.green.alpha.model.User;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Data
public class QuizUser {

    private UserDTO userDTO;
    private QuizDTO quizDTO;
    private Double score;



    public QuizUser(UserDTO userDTO, QuizDTO quizDTO){
        this.userDTO = userDTO;
        this.quizDTO = quizDTO;
    }


    public AnswerUser responds(int question, int posibleAnswer, boolean selected) {
        AnswerUser answerUser = new AnswerUser();
        answerUser.setUser(UserMapper.INSTANCE.toEntity(this.userDTO));
        answerUser.setAnswer(AnswerMapper.INSTANCE.answerDTOToAnswer(this.quizDTO.getQuestionsDTO().get(question-1).getAnswersDTO().get(posibleAnswer-1)));
        answerUser.setSelected(selected);
        return answerUser;
    }
}
