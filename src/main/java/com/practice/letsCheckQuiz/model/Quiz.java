package com.practice.letsCheckQuiz.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String QuizTitle;

    @ElementCollection
    private List<Integer> questionIds;

}
