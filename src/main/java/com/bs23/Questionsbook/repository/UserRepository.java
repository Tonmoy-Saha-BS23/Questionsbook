package com.bs23.Questionsbook.repository;

import com.bs23.Questionsbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
