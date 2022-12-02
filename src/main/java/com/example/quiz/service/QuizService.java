package com.example.quiz.service;

import com.example.quiz.entity.quiz_table;

import java.util.Optional;

public interface QuizService {

    Iterable<quiz_table> selectAll();

    Optional<quiz_table> selectOneById(Integer id);

    Optional<quiz_table> selectOneRandomQuiz();

    Boolean checkQuiz(Integer id, Boolean myAnswer);

    void insertQuiz(quiz_table quiz);

    void updateQuiz(quiz_table quiz);

    void deleteQuizById(Integer id);

}
