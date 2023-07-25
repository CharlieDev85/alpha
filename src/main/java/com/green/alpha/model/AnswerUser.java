package com.green.alpha.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "answer_user ")
public class AnswerUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private boolean selected;
}
