package com.green.alpha.mapper;

import com.green.alpha.dto.QuestionDTO;
import com.green.alpha.dto.QuizDTO;
import com.green.alpha.dto.UserDTO;
import com.green.alpha.model.Question;
import com.green.alpha.model.Quiz;
import com.green.alpha.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "createdQuizzesDTO", source = "createdQuizzes")
    //@Mapping(target = "answeredQuizzesDTO", source = "answeredQuizzes")
    UserDTO toDto(User user);


    @Mapping(target = "createdQuizzes", source = "createdQuizzesDTO")
    //@Mapping(target = "answeredQuizzes", source = "answeredQuizzesDTO")
    User toEntity(UserDTO userDTO);

    //////////////

    @Mapping(target = "questionsDTO", source = "questions")
        //@Mapping(target = "answersDTO", source = "answers")
    QuizDTO QuiztoQuizDTO(Quiz quiz);


    @Mapping(target = "questions", source = "questionsDTO")
        //@Mapping(target = "answers", source = "answersDTO")
    Quiz QuizDTOtoQuiz(QuizDTO quizDTO);

    @Mapping(target = "answers", source = "answersDTO")
    Question questionDTOToQuestion(QuestionDTO questionDTO);

    @Mapping(target = "answersDTO", source = "answers")
    QuestionDTO questionToQuestionDTO(Question question);

}
