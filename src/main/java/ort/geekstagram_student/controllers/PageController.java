/**
 * 
 */
package ort.geekstagram_student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ort.geekstagram_student.entities.User;
import ort.geekstagram_student.user.repository.IUserRepository;

/**
 * @author Severin
 *
 */
@Controller
public class PageController {
	
	@Autowired
	IUserRepository repository;

	@RequestMapping(method = RequestMethod.GET, value ="/login")
	public String UserLogin(){
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/research")
	public String GetResearch(@RequestParam("research") String research){
		User user = repository.findByName(research);
		if(user == null){
			user = repository.findByMail(research);
		}
		if(user !=null)
			return "redirect:/user/"+user.getId();
		else return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/index")
	public String GetIndex(){
		return "index";
	}
}
