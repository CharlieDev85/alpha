package com.green.alpha.repository;

import com.green.alpha.model.Answer;
import com.green.alpha.model.AnswerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerUserRepository extends JpaRepository<AnswerUser,Long> {

}
