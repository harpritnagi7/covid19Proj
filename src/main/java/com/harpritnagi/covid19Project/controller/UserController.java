package com.harpritnagi.covid19Project.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.harpritnagi.covid19Project.dao.UserBookingRepository;
import com.harpritnagi.covid19Project.dao.UserFeedbackRepository;
import com.harpritnagi.covid19Project.dao.UserRepository;
import com.harpritnagi.covid19Project.entities.Booking;
import com.harpritnagi.covid19Project.entities.Feedback;
import com.harpritnagi.covid19Project.entities.User;



@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserBookingRepository userBookingRepository;
	
	@Autowired
	private UserFeedbackRepository userFeedbackRepository;
	
	@Autowired
	private UserRepository userRepository;
	
//	METHOD TO ADD COMMON DATA	
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();
		System.out.println("USERNAME"+userName);
		
		//GET THE USERNAME(EMAIL)
		
		User user = userRepository.getUserByUserName(userName);
		
		System.out.println("USER "+user);
		
		model.addAttribute("user", user);
		
		
	}
	
//	DASHBOARD HOME
	@RequestMapping("/index")
	public String dashboard(Model model, Principal principal)
	{	
		return "normal/user_dashboard";
	}
	

//	FEEDBACK FORM
	@GetMapping("/feedbackform")
	public String feedbackform(Model model) {
		model.addAttribute("title","Feedback-Form");
		model.addAttribute("feedback",new Feedback());
		
		return "normal/feedbackform";
	}
	
//	PROCESSING ADD FEEDBACK FORM
	@PostMapping("/process-feedback")
	public String processfeedback(@ModelAttribute("feedback") Feedback feedback, Model model3) {
		model3.addAttribute("Feedback", feedback);
		Feedback result4 =this.userFeedbackRepository.save(feedback);
		model3.addAttribute("feedback", result4);
		
		
		return "normal/feedbackform";
	}
	
//	BOOKING MAPPING
	@GetMapping("/bookingform")
	public String bookingform(Model model) {
		model.addAttribute("tittle", "Booking form");
		return "normal/bookingform";
	}

	//per page = 5[n]
	// current page = 0[page]
//	BOOKING FORM 
	@PostMapping("/do-booking")
	public String dobooking(@ModelAttribute("booking") Booking booking, Model model4,  HttpSession session) {
		
		model4.addAttribute("booking", booking);
		Booking result5 = this.userBookingRepository.save(booking);
		model4.addAttribute("booking", result5);
		return "redirect:/user/success?do=booking your booking is successfully ..";
		
	}

	@GetMapping("/success")
	public String success() {
		return "normal/success";
	}
	
	
	
	

	
	
	}
	

