package com.practice.letsCheckQuiz.service;

import com.practice.letsCheckQuiz.feign.QuizInterface;
import com.practice.letsCheckQuiz.model.QuestionWrapper;
import com.practice.letsCheckQuiz.model.Quiz;
import com.practice.letsCheckQuiz.model.Submission;
import com.practice.letsCheckQuiz.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizInterface quizInterface;
    @Autowired
    QuizRepo quizRepo;
    public ResponseEntity<String> createQuiz(Integer noOfQues, String title) {
        List<Integer> questionIds = quizInterface.getQuestionsIdsForQuiz(noOfQues).getBody();
        Quiz quiz = new Quiz();
        quiz.setQuizTitle(title);
        quiz.setQuestionIds(questionIds);
        quizRepo.save(quiz);
        return new ResponseEntity<>("Quiz Created !", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId) {
        List<QuestionWrapper> questions = new ArrayList<>();

        Quiz quizDetails = quizRepo.findById(quizId).get();
        List<Integer> quesIds = quizDetails.getQuestionIds();
        List<Long> quesIdsToget = new ArrayList<>();
        for (Integer id: quesIds) {
            quesIdsToget.add(Long.valueOf(id));
        }
        questions = quizInterface.getQuestionsForQuiz(quesIdsToget).getBody();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Submission> submittedAnswers) {
        Integer score = quizInterface.getScore(submittedAnswers).getBody(); //from question service
        return  new ResponseEntity<>(score, HttpStatus.OK);
    }
}
