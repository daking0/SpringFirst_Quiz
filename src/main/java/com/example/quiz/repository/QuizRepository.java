package com.example.quiz.repository;

import com.example.quiz.entity.quiz_table;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<quiz_table,Integer> {
}
