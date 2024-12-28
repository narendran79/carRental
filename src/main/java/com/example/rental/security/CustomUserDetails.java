//package com.example.rental.security;
//
//import java.util.Collection;
//import java.util.Collections;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.example.rental.model.RegistrationRequest;
//
//public class CustomUserDetails implements UserDetails {
//	
//	private final RegistrationRequest registrationRequest;
//	
//	public CustomUserDetails(RegistrationRequest registrationRequest) {
//		this.registrationRequest = registrationRequest;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return registrationRequest.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return registrationRequest.getEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
//	public Long getUserId() {
//		return registrationRequest.getId();
//	}
//
//}
