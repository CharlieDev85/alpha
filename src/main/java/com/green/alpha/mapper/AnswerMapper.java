package com.green.alpha.mapper;

import com.green.alpha.dto.AnswerDTO;
import com.green.alpha.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    @Mapping(target = "questionDTO", source = "question") // Ignore mapping for the question field
    AnswerDTO answerToAnswerDTO (Answer answer);

    //@Mapping(target = "id", ignore = true) // Ignore mapping for the id field
    @Mapping(target = "question", source = "questionDTO")
    Answer answerDTOToAnswer(AnswerDTO answerDTO);
}
