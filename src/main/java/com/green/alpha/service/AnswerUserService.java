package com.green.alpha.service;

import com.green.alpha.dto.AnswerUserDTO;
import com.green.alpha.mapper.AnswerUserMapper;
import com.green.alpha.model.AnswerUser;
import com.green.alpha.repository.AnswerUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerUserService {

    private final AnswerUserRepository answerUserRepository;

    public AnswerUserService(AnswerUserRepository answerUserRepository) {
        this.answerUserRepository = answerUserRepository;
    }

    public AnswerUserDTO save (AnswerUserDTO answerUserDTO){
        AnswerUser answerUser = AnswerUserMapper.INSTANCE.toEntity(answerUserDTO);
        AnswerUser savedAnswerUser = answerUserRepository.save(answerUser);
        return AnswerUserMapper.INSTANCE.toDto(savedAnswerUser);
    }
}
