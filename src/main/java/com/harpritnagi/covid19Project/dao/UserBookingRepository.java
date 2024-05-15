package com.harpritnagi.covid19Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harpritnagi.covid19Project.entities.Booking;

public interface UserBookingRepository extends JpaRepository<Booking, Integer>{
	
	

}
