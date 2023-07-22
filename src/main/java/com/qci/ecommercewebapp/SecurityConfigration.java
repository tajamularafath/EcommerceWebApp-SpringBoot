//package com.qci.ecommercewebapp;
//
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigration{
//	 
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http
//        .authorizeHttpRequests()
//            .requestMatchers("/adminlogin").permitAll() // Allow access to the login page
//            .anyRequest().authenticated() // Require authentication for all other requests
//            .and()
//        .formLogin()
//            .loginPage("/adminlogin") // Set the login page URL
//            .defaultSuccessUrl("/") // Redirect to the dashboard on successful login
//            .and()
//        .logout()
//            .logoutUrl("/logout")
//            .logoutSuccessUrl("/adminlogin?logout") // Redirect to the login page after logout
//            .and()
//        .csrf().disable();
//        
//    return http.build();
//    }
//
//	    @Bean
//	    public UserDetailsService users() {
//	        UserDetails admin = User.builder()
//	            .username("admin")
//	            .password(passwordEncoder().encode("qwerty"))
//	            .roles("ADMIN")
//	            .build();
//	        System.out.println(admin);
//	        return new InMemoryUserDetailsManager(admin);
//	    }
//	    @Bean
//	    public PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }
//}
////	    @PostMapping("/login")
////	    public String login(@RequestParam("username") String username) {
////	        // Handle login logic
////	        return "Login successful for user: " + username;
////	    }}
