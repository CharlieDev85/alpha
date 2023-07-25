package com.green.alpha;

import com.green.alpha.dto.AnswerDTO;
import com.green.alpha.dto.QuestionDTO;
import com.green.alpha.mapper.AnswerMapper;
import com.green.alpha.model.Answer;
import com.green.alpha.model.Question;
import com.green.alpha.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AlphaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlphaApplication.class, args);
		System.out.println("hello there!");

	}

}
