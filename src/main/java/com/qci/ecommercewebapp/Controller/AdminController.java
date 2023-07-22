package com.qci.ecommercewebapp.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qci.ecommercewebapp.Model.Admin;
import com.qci.ecommercewebapp.Repository.AdminRepo;
import com.qci.ecommercewebapp.Service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@Autowired private AdminService adminService;
	
	@Autowired private AdminRepo adminRepo;
	
	//Admin Login API
	@GetMapping("/adminlogin")
	public String adminLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginadmin") != null) {
			
			return "index";
			}
		else {
				return "adminlogin";
			}
	}
	
	@RequestMapping("/checkslogin")
	public String checksLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
		
		
		Optional<Admin> adminoptional = adminService.findByUsername(username);
		
		if(adminoptional.isPresent()) {
			
			Admin admin = adminoptional.get();
			System.out.println(admin.getUsername());
			
			if(adminService.checkedPassword(password, admin.getPassword())) {
				HttpSession session = request.getSession();
		      session.setAttribute("loginadmin", admin.getUsername());
				
				System.out.println();
				System.out.println("checkpaword");
				return "redirect:/";
			}
			System.out.println("Username is present " +adminoptional);
		}
		else {
			System.out.println("Not present"+ adminoptional);
			return "/adminreg";
		}
		return "/adminlogin";
	}

	@GetMapping("/")
	public String home(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String loggedadmin = (String) session.getAttribute("loginadmin");
		System.out.println(loggedadmin+"----=");
		if(loggedadmin != null) {
			
			return "index";
		} else {
			return "redirect:/adminlogin";
		}
	}
	@RequestMapping("/logoutadmin")
	public String logoutAdmin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginadmin");
//		session.invalidate();
//		session.setMaxInactiveInterval(0);
//		session = null;
		System.out.println("logoutmethod ===>"+session.toString());
		return "redirect:/adminlogin";
	}
	
	@GetMapping("adminreg")
	public String adminReg(HttpServletRequest request) {
		Admin admin = new Admin();
		HttpSession session = request.getSession();
		session.setAttribute("regdata", admin.getUsername() );
		return "adminreg";
	}
	
	@RequestMapping("addadmin")
	public String addAdmin(@ModelAttribute Admin admin, HttpServletRequest request) {
//		int id = admin.getId();
		String username = admin.getUsername();
		String password = admin.getPassword();
		String email = admin.getEmail();
		
		Admin newadmin = new Admin(0,username,password,email);
		adminRepo.save(newadmin);
		return "adminlogin";
			
		}
	}

	

	
//{checklogin}
//		String username = ok.getUsername();
//		String password = ok.getPassword();

//	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	    if (auth.isAuthenticated()) {
//	        return "redirect:/";
//	    } else {
//	    	return "adminlogin";
//	    }
