//package com.example.rental.security;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import com.example.rental.model.RegistrationRequest;
//
//import com.example.rental.repository.UserRepository;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean 
//	public UserDetailsService userDetailsService() {
//		return email -> {
//			List<RegistrationRequest> user = userRepository.findByEmail(email);
//			if(user.isEmpty()) {
//				throw new UsernameNotFoundException("user not found " + email);
//			}
//			return new CustomUserDetails(user.get(0));
//		};
//	}
//
//}
