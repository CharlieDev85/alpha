package com.green.alpha.repository;

import com.green.alpha.model.Question;
import com.green.alpha.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

}
