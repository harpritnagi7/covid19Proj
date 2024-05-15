package com.harpritnagi.covid19Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harpritnagi.covid19Project.entities.Feedback;

public interface UserFeedbackRepository extends JpaRepository<Feedback, Integer>{
	
	

}
