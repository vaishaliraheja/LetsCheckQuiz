package com.practice.letsCheckQuiz.feign;

import com.practice.letsCheckQuiz.model.QuestionWrapper;
import com.practice.letsCheckQuiz.model.Submission;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("LETSCHECKQUESTION")
public interface QuizInterface {
    @GetMapping("/questions/generateQuiz/{numOfQues}")
    public ResponseEntity<List<Integer>> getQuestionsIdsForQuiz(@PathVariable Integer numOfQues);


    @PostMapping("/questions/getQuestionsForQuiz")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsForQuiz(@RequestBody List<Long> quesIds);
    //getResult
    @PostMapping("/questions/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Submission> submittedQuiz);
}
