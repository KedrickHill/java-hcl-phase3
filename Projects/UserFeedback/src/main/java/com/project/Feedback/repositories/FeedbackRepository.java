package com.project.Feedback.repositories;

import org.springframework.data.repository.CrudRepository;

import com.project.Feedback.entities.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {

}
