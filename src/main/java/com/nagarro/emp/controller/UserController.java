package com.nagarro.emp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.emp.service.UserService;

@Controller
@RequestMapping(path="/")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	
	@GetMapping("/home")
	public String goToLogin() {
		System.out.println("Inside login");
		return "login";
	}
	

	@PostMapping("/login")
	public String userLogin(@RequestParam("userId") int userId, @RequestParam("userPass") String userPass,Model model) {
		boolean isLogged=false;
		System.out.println(userId+"\t"+userPass);
		isLogged=userService.isLogin(userId, userPass);
		System.out.println(isLogged);
		if(!isLogged) {
			model.addAttribute("logInMessage","Invalid User");
			model.addAttribute("auth","false");
			System.out.println("not logged");
			return "redirect:/home";
		}
		model.addAttribute("auth",true);
		return "redirect:/allEmp";
	}
	
}
