package com.harpritnagi.covid19Project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.harpritnagi.covid19Project.dao.UserRepository;
import com.harpritnagi.covid19Project.entities.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.getUserByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("couldn't found user");
		}

		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		return customUserDetails;
	}

//	Userdetailservice implemented(Impl short form for implementation) click on darn 
//	red bulb implement unimplemented methods 
// use dao repo for database
}
