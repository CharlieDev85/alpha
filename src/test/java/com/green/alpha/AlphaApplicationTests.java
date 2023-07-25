package com.green.alpha;

import com.green.alpha.dto.*;
import com.green.alpha.mapper.AnswerMapper;
import com.green.alpha.model.Answer;
import com.green.alpha.model.AnswerUser;
import com.green.alpha.model.Question;
import com.green.alpha.repository.QuestionRepository;
import com.green.alpha.service.AnswerUserService;
import com.green.alpha.service.QuestionService;

import com.green.alpha.service.QuizService;
import com.green.alpha.service.UserService;
import com.green.alpha.util.QuizUser;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional // Rollback transactions after each test
class AlphaApplicationTests {

    Question question;
    QuestionDTO questionDTO;

    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizService quizService;
    @Autowired
    private AnswerUserService answerUserService;

    @Test
    void contextLoads() {
    }

    @BeforeEach
    void setup() {
        Answer answer1 = new Answer();
        answer1.setId(1L);
        answer1.setText("am");
        answer1.setCorrect(true);

        Answer answer2 = new Answer();
        answer2.setId(2L);
        answer2.setText("are");
        answer2.setCorrect(false);

        Answer answer3 = new Answer();
        answer3.setId(2L);
        answer3.setText("is");
        answer3.setCorrect(false);

        question = new Question();
        question.setId(1L);
        question.setText("I _____ a developer.");
        question.setAnswers(List.of(answer1, answer2, answer3));

        ///////////////////
        //Creating a QuestionDTO
        AnswerDTO answerDTO1 = new AnswerDTO("am", true);
        AnswerDTO answerDTO2 = new AnswerDTO("are", false);
        AnswerDTO answerDTO3 = new AnswerDTO("is", false);
        questionDTO = new QuestionDTO("I ___ a developer.", List.of(answerDTO1, answerDTO2, answerDTO3));

    }

    /*
    https://mapstruct.org/faq/
    Can I use MapStruct together with Project Lombok?
    Essentially, MapStruct will wait until Lombok has done all its amendments before generating mapper classes for Lombok-enhanced beans.
     */
    @Test
    public void shouldMapAnswerToDto() {
        //given
        Answer answer = new Answer();
        answer.setId(1L);
        answer.setText("am");
        answer.setCorrect(true);
        //when
        AnswerDTO answerDTO = AnswerMapper.INSTANCE.answerToAnswerDTO(answer);
        //then
        System.out.println(answerDTO.toString());
        assertThat(answerDTO).isNotNull();
        assertThat(answerDTO.getId()).isEqualTo(1L);
        assertThat(answerDTO.getText()).isEqualTo("am");
        assertThat(answerDTO.isCorrect()).isEqualTo(true);
    }

    @Test
    public void shouldCreateAQuestion() {
        assertThat(question).isNotNull();
        assertThat(question.getAnswers().size()).isEqualTo(3);
        assertThat(question.getAnswers().get(0).isCorrect()).isEqualTo(true);
    }

    @Test
    void shouldSaveQuestionInDB() {
        QuestionDTO savedQuestionDTO = questionService.save(this.questionDTO);
        assertThat(savedQuestionDTO).isNotNull();
        assertThat(savedQuestionDTO.getText()).isEqualTo("I ___ a developer.");
        assertThat(savedQuestionDTO.getId()).isGreaterThan(0L);
        assertThat(savedQuestionDTO.getAnswersDTO()).isNotNull();

        Long id = savedQuestionDTO.getId();
        QuestionDTO questionFromDB = questionService.findById(id);
        assertThat(questionFromDB).isNotNull();
        assertThat(questionFromDB.getAnswersDTO().size()).isEqualTo(3);
    }

    @Test
    void shouldSaveAndRecoverQuestion() {
        Question question = new Question();
        question.setText("She is __ doctor");
        Answer answer1 = new Answer();
        answer1.setText("a");
        answer1.setCorrect(true);
        Answer answer2 = new Answer();
        answer2.setText("an");
        answer2.setCorrect(false);
        question.setAnswers(List.of(answer1, answer2));
        Question questionSaved = questionRepository.save(question);
        System.out.println(questionSaved);
        Question questionRecovered = questionRepository.findById(questionSaved.getId()).get();
        System.out.println(questionRecovered);
        System.out.println(questionRecovered.getAnswers());
    }


    @Test
    public void testingIt() {
        Answer answer = new Answer();
        answer.setId(1L);
        answer.setText("am");
        answer.setCorrect(true);
        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setId(answer.getId());
        answerDTO.setCorrect(answer.isCorrect());
        assertThat(answerDTO.getId()).isEqualTo(1L);
        assertThat(answerDTO.isCorrect()).isEqualTo(true);
    }


    @Test
    public void shouldSaveAndRecoverUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Charlie");
        userDTO.setLastName("Sheen");
        userDTO.setEmail("charliemarroq@gmail.com");
        UserDTO userSaved = userService.save(userDTO);
        assertThat(userSaved).isNotNull();
        assertThat(userSaved.getLastName()).isEqualTo("Sheen");
        Long id = userSaved.getId();
        UserDTO recoveredUserDTO = userService.findById(id);
        assertThat(recoveredUserDTO).isNotNull();
        assertThat(recoveredUserDTO.getEmail()).isEqualTo("charliemarroq@gmail.com");
    }

    @Test
    public void userCreatesAQuiz() {
        AnswerDTO answerDTO1 = new AnswerDTO("am", true);
        AnswerDTO answerDTO2 = new AnswerDTO("are", false);
        AnswerDTO answerDTO3 = new AnswerDTO("is", false);
        QuestionDTO verbToBeQuestion = new QuestionDTO("I ___ a developer.", List.of(answerDTO1, answerDTO2, answerDTO3));

        AnswerDTO answerDTO4 = new AnswerDTO("was", true);
        AnswerDTO answerDTO5 = new AnswerDTO("were", false);
        AnswerDTO answerDTO6 = new AnswerDTO("were'nt", false);
        QuestionDTO pastTenseQuestion = new QuestionDTO("I ___ a developer.", List.of(answerDTO4, answerDTO5, answerDTO6));

        UserDTO userDTO = new UserDTO("charles", "whitmore", "cwithmore@mail.com");

        String title = "First Test";
        String instructions = "Answer the following questions";
        QuizDTO myQuiz = new QuizDTO(userDTO, title, instructions, 40d, List.of(verbToBeQuestion, pastTenseQuestion));
        QuizDTO savedQuiz = quizService.save(myQuiz);

        QuizDTO recoveredQuiz = quizService.findById(savedQuiz.getId());
        assertThat(recoveredQuiz).isNotNull();
        assertThat(recoveredQuiz.getCreator()).isNotNull();
        assertThat(recoveredQuiz.getCreator().getFirstName()).isEqualTo("charles");
        assertThat(recoveredQuiz.getQuestionsDTO().size()).isEqualTo(2);
    }

    @Test
    public void userTriesAQuiz() {
        AnswerDTO answerDTO1 = new AnswerDTO("am", true);
        AnswerDTO answerDTO2 = new AnswerDTO("are", false);
        AnswerDTO answerDTO3 = new AnswerDTO("is", false);
        QuestionDTO verbToBeQuestion = new QuestionDTO("I ___ a developer.", List.of(answerDTO1, answerDTO2, answerDTO3));
        AnswerDTO answerDTO4 = new AnswerDTO("was", true);
        AnswerDTO answerDTO5 = new AnswerDTO("were", false);
        AnswerDTO answerDTO6 = new AnswerDTO("were'nt", false);
        QuestionDTO pastTenseQuestion = new QuestionDTO("I ___ a waiter.", List.of(answerDTO4, answerDTO5, answerDTO6));
        UserDTO creator = new UserDTO("charles", "whitmore", "cwithmore@mail.com");
        String title = "First Test";
        String instructions = "Answer the following questions";
        QuizDTO myQuiz = new QuizDTO(creator, title, instructions, 40d, List.of(verbToBeQuestion, pastTenseQuestion));
        QuizDTO savedQuiz = quizService.save(myQuiz);
        QuizDTO recoveredQuiz = quizService.findById(savedQuiz.getId());
        UserDTO student = new UserDTO("Sarah", "Blackmore", "sblackmoree@mail.com");
        UserDTO studentSaved = userService.save(student);
        UserDTO recoveredStudent = userService.findById(studentSaved.getId());
        for (QuestionDTO questionDTO : recoveredQuiz.getQuestionsDTO()) {
            //1
            AnswerDTO answer1 = questionDTO.getAnswersDTO().get(0);
            AnswerUserDTO answerUser1 = new AnswerUserDTO();
            answerUser1.setAnswerDTO(answer1);
            answerUser1.setUserDTO(recoveredStudent);
            answerUser1.setSelected(true);
            AnswerUserDTO savedAnswerUserDTO1 = answerUserService.save(answerUser1);
            assertThat(savedAnswerUserDTO1).isNotNull();
            //2
            AnswerDTO answer2 = questionDTO.getAnswersDTO().get(1);
            AnswerUserDTO answerUser2 = new AnswerUserDTO();
            answerUser2.setAnswerDTO(answer2);
            answerUser2.setUserDTO(recoveredStudent);
            answerUser2.setSelected(false);
            AnswerUserDTO savedAnswerUserDTO2 = answerUserService.save(answerUser2);
            assertThat(savedAnswerUserDTO2).isNotNull();
            //3
            AnswerDTO answer3 = questionDTO.getAnswersDTO().get(2);
            AnswerUserDTO answerUser3 = new AnswerUserDTO();
            answerUser3.setAnswerDTO(answer3);
            answerUser3.setUserDTO(recoveredStudent);
            answerUser3.setSelected(false);
            AnswerUserDTO savedAnswerUserDTO3 = answerUserService.save(answerUser3);
            assertThat(savedAnswerUserDTO3).isNotNull();
        }
    }

/*
	QuizUser quizStudent = new QuizUser(recoveredStudent,recoveredQuiz );

		quizStudent.responds(1,1,true);
		quizStudent.responds(1,2,false);
		quizStudent.responds(1,3,false);
		quizStudent.responds(2,1,false);
		quizStudent.responds(2,2,false);
		quizStudent.responds(2,3,true);

 */


}
