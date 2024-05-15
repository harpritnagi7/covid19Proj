package com.harpritnagi.covid19Project.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harpritnagi.covid19Project.dao.UserRepository;
import com.harpritnagi.covid19Project.entities.User;
import com.harpritnagi.covid19Project.service.EmailService;




@Controller
public class ForgotController {
    Random random = new Random(1000);
    
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @RequestMapping("/forgot")
    public String openEmailForm(){
        return "forgot_email_form";
    }
    @PostMapping("/send-otp")
    public String sendotp(@RequestParam("email") String email, HttpSession session){
        System.out.println("Email "+email);

        // Generating 4 digit otp
       

        int otp = random.nextInt(99999);
        System.out.println("OTP "+otp);

        // Write code to send email to otp
        
        String subject="OTP From SCM";
        String message= ""
        +"<div style='border:1px solid #e2e2e2; padding:20px'>"
        +"<h1>"
        +"OTP is-"
        +"<b>"+otp
        +"</n>"
        +"</h1>"
        +"</div>";
        
        
        
        String to=email;
  
        boolean flag = this.emailService.sendEmail(subject, message, to);
        if(flag){
     
        	
        	session.setAttribute("myotp", otp);
            session.setAttribute("email", email);
        	
        	return "verify_otp";
        }else{

            session.setAttribute("messsage", "check your email id");
            return "forgot_email_form";
        }

        
    }

    // verify otp
    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam("otp") int otp,HttpSession session){

        int myOtp = (int)session.getAttribute("myotp");
        String email= (String)session.getAttribute("email");

        if(myOtp==otp){

          User user = this.userRepository.getUserByUserName(email);

          if(user==null)
          {
              //send error message
              session.setAttribute("messsage", "No user exist with this email");
              return "forgot_email_form";

          }else{
            //   send change password form
            
          }


            return "password_change_form";

        }else{
            session.setAttribute("message", "You've entered wrong otp !");
            return "verify_otp";
        }

    }
    // change password
    @PostMapping("/password-change")
    public String changePassword(@RequestParam("newpassword") String newpassword, HttpSession session){
        String email= (String)session.getAttribute("email");
        User user = this.userRepository.getUserByUserName(email);
        user.setPassword(this.bcrypt.encode(newpassword));
        this.userRepository.save(user);
        return "redirect:/login?change=password changed successfully ..";
        
    }
}
