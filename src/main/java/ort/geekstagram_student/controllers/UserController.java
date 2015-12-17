/**
 * 
 */
package ort.geekstagram_student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ort.geekstagram_student.entities.User;
import ort.geekstagram_student.user.repository.IUserRepository;
import ort.geekstagram_student.user.service.IUserService;

/**
 * @author Severin
 * Version 1.0
 */
@Controller
public class UserController {
	
	@Autowired
	IUserRepository repository;
	
	@Autowired
	@Qualifier("MysqlUserService")
	private IUserService userService;
	
	//URL = RequestMapping View = return string
	@RequestMapping(method = RequestMethod.GET,value = "/user")
	public String ShowUser(Model model){
		model.addAttribute("users", userService.GetAll());
		return "Users";
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/user")
	public String UserCreation(@RequestParam("Name") String name, @RequestParam("Mail") String mail,
			@RequestParam("Password") String password){
		userService.Add(new User(name,mail,password));
		return "Users";
	}
}
