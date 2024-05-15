package com.harpritnagi.covid19Project.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.harpritnagi.covid19Project.entities.User;

public class CustomUserDetails implements UserDetails{
	
	private User user;
	
	
	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());
		
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
				return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
				return true;
	}

	@Override
	public boolean isAccountNonLocked() {
				return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	//implements user details
	//our second step for spring security
	//than there gonna be an error just move the 
	//cursor and add unimplemented method
	//make private variable User import from entities make user object than constructor using fields
	//than in override return write getpassword and getemail and convert all false to true
//	than write this --> SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());	
//	and this --> return List.of(simpleGrantedAuthority);
// just do it dammit
}
