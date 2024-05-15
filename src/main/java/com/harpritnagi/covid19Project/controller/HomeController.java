package com.harpritnagi.covid19Project.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.harpritnagi.covid19Project.dao.UserRepository;
import com.harpritnagi.covid19Project.entities.Booking;
import com.harpritnagi.covid19Project.entities.LocationStats;
import com.harpritnagi.covid19Project.entities.User;
import com.harpritnagi.covid19Project.helper.Message;
import com.harpritnagi.covid19Project.service.CoronaVirusDataService;

@Controller
public class HomeController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	

	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home-COVID-19APP");
		return "home";
	}

	@RequestMapping("/booking")
	public String boking(Model model) {
		model.addAttribute("tittle", "Hospital-Booking");
		model.addAttribute("booking", new Booking());
		return "booking";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About-COVID-19APP");
		return "about";
	}




	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "SignUp-COVID-19APP");
		model.addAttribute("user", new User());
		return "signup";
	}

//	 handler for register user
	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result1,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,
			HttpSession session) {
		try {
			if (!agreement) {
				System.out.println("You have not agreed to the terms and condions");
				throw new Exception("You have not agreed to the terms and condions");
			}

			if (result1.hasErrors()) {
				System.out.println("ERROR " + result1.toString());
				model.addAttribute("user", user);
				return "signup";
			}

			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("default.png");

			user.setPassword(passwordEncoder.encode(user.getPassword())); // for encodedpassword

			System.out.println("Agreement" + agreement);
			System.out.println("user " + user);

			User result = this.userRepository.save(user);

			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Succesfully Signed Up", "alert-success"));
			return "signup";

		} catch (Exception e) {

			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something went wrong " + e.getMessage(), "alert-danger"));
			return "signup";
		}

	}

//	HANDLER FOR CUSTOM LOGIN PAGE 
	@GetMapping("/login")
	public String customLogin(Model model) {
		model.addAttribute("title", "Login-COVID-19APP");
		return "login";
	}
	



	// --ALERT--MY-BOI-TRACKER-HERE-MADE-BY-NAGI
	@Autowired
	CoronaVirusDataService coronaVirusDataService;

	@GetMapping("/tracker")
	public String tracker(Model model) {
		List<LocationStats> allStats = coronaVirusDataService.getAllStats();
		int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPreviousDay()).sum();
		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalReportedCases", totalReportedCases);
		model.addAttribute("totalNewCases", totalNewCases);
		return "tracker"; 
	}
}
