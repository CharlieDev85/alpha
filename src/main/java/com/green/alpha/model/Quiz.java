package com.green.alpha.model;

import lombok.Data;

import java.util.List;
@Data
public class Quiz {

    private Long id;
    private User creator;
    private String title;
    private String instructions;
    private Double maxScore;
    private List<Question> questions;

}
