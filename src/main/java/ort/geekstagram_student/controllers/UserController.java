/**
 * 
 */
package ort.geekstagram_student.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "users";
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/user")
	public String UserCreation(@RequestParam("Name") String name, @RequestParam("Mail") String mail,
			@RequestParam("Password") String password){
		userService.Add(new User(name,mail,password));
		return "users";
	}	
	
	
	@RequestMapping(method = RequestMethod.POST, value ="/signin")
	public String Signin(@RequestParam("NameOrMail") String nameOrMail,
			@RequestParam("Password") String password, HttpSession session){
		User userByName = userService.GetByName(nameOrMail);
		User userByMail = userService.GetByMail(nameOrMail);
		if(userByName!= null){
			session.setAttribute("user", userByName);
			return "users";
		}
		else if(userByMail!= null){
			session.setAttribute("user", userByMail);
			return "users";
		}			
		else return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/user/{id}")
	public String ShowProfile(@PathVariable("id") long id, Model model){
		if(repository.exists(id)){
			model.addAttribute("user", userService.Get(id));
			return "user";
		}			
		else return "hello";
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/signout")
	public String Signout(HttpSession session){
		session.invalidate();
		return "index";
	}
}
