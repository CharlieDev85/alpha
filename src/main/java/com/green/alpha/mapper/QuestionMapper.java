package com.green.alpha.mapper;


import com.green.alpha.dto.AnswerDTO;
import com.green.alpha.dto.QuestionDTO;
import com.green.alpha.model.Answer;
import com.green.alpha.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mapping(target = "answersDTO", source = "answers")
    @Mapping(target = "quizDTO", source = "quiz")
    QuestionDTO toDTO(Question question);


    @Mapping(target = "answers", source = "answersDTO")
    @Mapping(target = "quiz", source = "quizDTO")
    Question toEntity(QuestionDTO questionDTO);




}
