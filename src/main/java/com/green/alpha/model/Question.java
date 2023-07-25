package com.green.alpha.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;
    @Column
    private String text;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    //@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}

/*
* Let's break down the parameters of the @OneToMany annotation:

mappedBy = "question": This parameter specifies the field in the Answer entity that owns the relationship.
* It indicates that the relationship is bidirectional, and the ownership of the relationship lies in the
*  question field of the Answer entity.

cascade = CascadeType.ALL: This parameter specifies the cascade behavior for the relationship.
* The CascadeType.ALL option means that any changes made to the Question entity, including inserts, updates,
* and deletions, should be cascaded to the associated Answer entities. For example, if a Question is deleted,
* all its associated Answer entities will be deleted as well.

orphanRemoval = true: This parameter specifies the orphan removal behavior. When set to true, it means that
* if an Answer entity is removed from the answers collection of a Question, and it is no longer referenced by
* any other entities, it should be automatically deleted from the database. This ensures that orphaned Answer
* entities are properly removed.
* */
