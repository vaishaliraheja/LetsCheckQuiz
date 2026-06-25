package com.practice.letsCheckQuiz.controllers;

import com.practice.letsCheckQuiz.model.QuestionWrapper;
import com.practice.letsCheckQuiz.model.QuizWrapper;
import com.practice.letsCheckQuiz.model.Submission;
import com.practice.letsCheckQuiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {
    @Autowired
    QuizService quizService;
    //createQuiz
    @PostMapping("/createQuiz")
    public ResponseEntity<String> createQuiz(@RequestBody QuizWrapper quiz) {
        return quizService.createQuiz(quiz.getNoOfQues(), quiz.getQuizTitle());
    }

    //getQuizQuestions
    @GetMapping("/getQuiz/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer quizId) {
        return quizService.getQuizQuestions(quizId);
    }

    //submit
    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Submission> submittedAnswers) {
        return  quizService.getScore(submittedAnswers);
    }
}
