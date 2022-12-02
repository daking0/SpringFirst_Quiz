package com.example.quiz;

import com.example.quiz.entity.quiz_table;
import com.example.quiz.repository.QuizRepository;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args)
		.getBean(QuizApplication.class).execute();
	}

	@Autowired
	QuizService service;

	private void execute(){
//		setup();
//		showList();
//		showOne();
		updateQuiz();
		deleteQuiz();
	}


	private void setup(){
		quiz_table quiztable1 = new quiz_table(null,"Spring은 프레임워크입니가?",true,"홍길동");
//		quiztable1 = repository.save(quiztable1);
		System.out.println("등록한 퀴즈는 "+ quiztable1 +"입니다.");

		quiz_table quiztable2 = new quiz_table(null,"스프링 mvc는 배치처리 제공합니가?",false,"홍길동");
//		quiztable2 = repository.save(quiztable2);

		List<quiz_table> quizList = new ArrayList<>();
		Collections.addAll(quizList,quiztable1,quiztable2);

		for(quiz_table quiz:quizList){
			service.insertQuiz(quiz);
		}

		System.out.println("등록 완료");

	}

	private void showList(){
		System.out.println("--모든 데이터 취득 개시--");
		Iterable<quiz_table> quizzes = service.selectAll();
		for(quiz_table quiz:quizzes){
			System.out.println(quiz);
		}
		System.out.printf("====완료======");
	}

	private void showOne(){
		Optional<quiz_table> quizOpt = service.selectOneById(1);

		if(quizOpt.isPresent()){
			System.out.println(quizOpt.get());
		}else{
			System.out.println("--없ㅇ음--");
		}
	}

	private void updateQuiz(){
		quiz_table quiz1 = new quiz_table(1,"스프링 프레임워크입니까?",true,"변경 담당");
//		quiz1 = repository.save(quiz1);
		service.updateQuiz(quiz1);
		System.out.println(quiz1+"완료");
	}

	private void deleteQuiz(){
		service.deleteQuizById(2);
		System.out.println("삭제 완료");
	}
}
