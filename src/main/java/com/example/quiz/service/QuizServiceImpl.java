package com.example.quiz.service;

import com.example.quiz.entity.quiz_table;
import com.example.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository repository;

    @Override
    public Iterable<quiz_table> selectAll() {
        return repository.findAll();
    }

    @Override
    public Optional<quiz_table> selectOneById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<quiz_table> selectOneRandomQuiz() {
        Integer randid = 3;

        if(randid==null){
            return Optional.empty();
        }
        return repository.findById(randid);
    }

    @Override
    public Boolean checkQuiz(Integer id, Boolean myAnswer) {
        Boolean check =false;

        Optional<quiz_table> optquize = repository.findById(id);
        if(optquize.isPresent()){
            quiz_table quiz = optquize.get();

            if(quiz.getAnswer().equals(myAnswer)){
                check = true;
            }
        }
        return check;
    }

    @Override
    public void insertQuiz(quiz_table quiz) {
        repository.save(quiz);
    }

    @Override
    public void updateQuiz(quiz_table quiz) {
        repository.save(quiz);
    }

    @Override
    public void deleteQuizById(Integer id) {
        repository.deleteById(id);
    }
}
