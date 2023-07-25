package com.green.alpha.mapper;

import com.green.alpha.dto.AnswerDTO;
import com.green.alpha.dto.QuestionDTO;
import com.green.alpha.dto.QuizDTO;
import com.green.alpha.model.Answer;
import com.green.alpha.model.Question;
import com.green.alpha.model.Quiz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface QuizMapper {

    QuizMapper INSTANCE = Mappers.getMapper(QuizMapper.class);

    @Mapping(target = "questionsDTO", source = "questions")
    //@Mapping(target = "answersDTO", source = "answers")
    QuizDTO toDto(Quiz quiz);


    @Mapping(target = "questions", source = "questionsDTO")
    //@Mapping(target = "answers", source = "answersDTO")
    Quiz toEntity(QuizDTO quizDTO);

    @Mapping(target = "answers", source = "answersDTO")
    Question questionDTOToQuestion(QuestionDTO questionDTO);

    @Mapping(target = "answersDTO", source = "answers")
    QuestionDTO questionToQuestionDTO(Question question);



}
