/**
 * 
 */
package ort.geekstagram_student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ort.geekstagram_student.entities.Post;
import ort.geekstagram_student.entities.User;
import ort.geekstagram_student.posts.repository.IPostRepository;
import ort.geekstagram_student.user.repository.IUserRepository;

/**
 * @author Severin
 *
 */
@Controller
public class UtilsController {
	
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	IPostRepository postRepository;

	@RequestMapping(method = RequestMethod.GET, value ="/login")
	public String UserLogin(){
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/research")
	public String GetResearch(@RequestParam("research") String research){
		User user = userRepository.findByName(research);
		Post post = postRepository.findByTitle(research);
		if(user == null){
			user = userRepository.findByMail(research);
		}
		if(user !=null)
			return "redirect:/user/"+user.getId();
		if(post!=null)
			return "redirect:/post/"+post.getId();
		else return "/posts";
	}
}
