/**
 * 
 */
package ort.geekstagram_student.controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ort.geekstagram_student.entities.Like;
import ort.geekstagram_student.entities.Post;
import ort.geekstagram_student.entities.User;
import ort.geekstagram_student.likes.service.ILikeService;
import ort.geekstagram_student.posts.service.IPostService;
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
	@Qualifier("MySQLUserService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("MySQLPostService")
	private IPostService postService;
	
	@Autowired
	@Qualifier("MySQLLikeService")
	private ILikeService likeService;
	
	/**
	 * Methode qui ne sert qu'a afficher la page de création de compte
	 * */
	@RequestMapping(method = RequestMethod.GET,value = "/user")
	public String ShowUser(){
		return "/users";
	}
	
	/**
	 * Methode de création de compte
	 * les champs de la base de données sont unique alors une erreur sera retournée si un champ existe deja (pas testé&)
	 * si la création réussi on affiche la page principale
	 * */
	@RequestMapping(method = RequestMethod.POST, value ="/createUser")
	public String CreateUser(@RequestParam("Name") String name, @RequestParam("Mail") String mail,
			@RequestParam("Password") String password, Model model, HttpSession session){
		try{
		User newUser = new User(name,mail,password);
		userService.Add(newUser);
		session.setAttribute("user", newUser);
		return "redirect:/posts";
		}
		catch(Exception ex){
			model.addAttribute("error", ex.getMessage());
			return "/users";
		}
	}
	
	/**
	 * Methode qui update le compte
	 * */
	@RequestMapping(method = RequestMethod.POST, value ="/updateUser")
	public String UpdateUser(@RequestParam("Name") String name, @RequestParam("Mail") String mail,
			@RequestParam("Password") String password, Model model, HttpSession session){
		try{
			if(repository.exists(((User)session.getAttribute("user")).getId())){
				User user = (User)session.getAttribute("user");
				user.setMail(mail);
				user.setName(name);
				user.setPassword(password);
				if(repository.save(user) == user){
					session.removeAttribute("user");
					session.setAttribute("user", user);
					return "redirect:/posts";
				}
			}
			else throw new Exception("You cheating liar");
		}
		catch(Exception ex){
			model.addAttribute("error", ex.getMessage());
			return "/users";
		}
		return "redirect:/posts";
	}	
	
	/**
	 * Methode d'authentification
	 * */
	@RequestMapping(method = RequestMethod.POST, value ="/signin")
	public String Signin(@RequestParam("NameOrMail") String nameOrMail,
			@RequestParam("Password") String password, HttpSession session, Model model){
		User userByName = userService.GetByName(nameOrMail);
		User userByMail = userService.GetByMail(nameOrMail);
		if(userByName!= null){
			session.setAttribute("user", userByName);
			return "redirect:/posts";
		}
		else if(userByMail!= null){
			session.setAttribute("user", userByMail);
			return "redirect:/posts";
		}			
		else{
			model.addAttribute("error", true);
			return "/login";
		}
	}
	
	/**
	 * Methode pour afficher le profil
	 * */
	@RequestMapping(method = RequestMethod.GET, value ="/user/{id}")
	public String ShowProfile(@PathVariable("id") long id, Model model){
		if(repository.exists(id)){
			
			List<Post> posts = postService.getAllPostByUser(id);
			Map<Post, HashMap<Integer, Integer>> postsComments = new HashMap<Post, HashMap<Integer, Integer>>();
			for (Iterator<Post> i = posts.iterator(); i.hasNext();) {
				Post item = i.next();
				List<Post> comments = postService.getAllComments((int) item.getId());
				List<Like> likes = likeService.getAllLikesByPost((int) item.getId());

				HashMap<Integer, Integer> coms_likes = new HashMap<Integer, Integer>();
				coms_likes.put(comments.size(), likes.size());

				postsComments.put(item, coms_likes);
			}

			
			model.addAttribute("posts",postsComments);
			model.addAttribute("user", userService.Get(id));
			return "/user";
		}			
		else return "redirect:/posts";
	}
	
	/**
	 * Methode pour se deconnecter
	 * */
	@RequestMapping(method = RequestMethod.GET, value ="/signout")
	public String Signout(HttpSession session){
		session.invalidate();
		return "redirect:/posts";
	}
}
