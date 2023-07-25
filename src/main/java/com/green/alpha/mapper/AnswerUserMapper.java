package com.green.alpha.mapper;

import com.green.alpha.dto.AnswerDTO;
import com.green.alpha.dto.AnswerUserDTO;
import com.green.alpha.model.Answer;
import com.green.alpha.model.AnswerUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerUserMapper {
    AnswerUserMapper INSTANCE = Mappers.getMapper(AnswerUserMapper.class);

    AnswerUserDTO toDto (AnswerUser answerUser);

    AnswerUser toEntity(AnswerUserDTO answerUserDTO);
}
