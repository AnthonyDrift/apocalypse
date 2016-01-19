package ort.geekstagram_student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ort.geekstagram_student.posts.service.IPostService;
import ort.geekstagram_student.entities.Post;
@Controller
public class PostController {

	@Autowired
	@Qualifier("MYSQLPostService")
	private IPostService postService;  
	
	@RequestMapping(method = RequestMethod.GET, value = "/post")
	public String index(Model model){
		model.addAttribute("error", "C'est toi l'erreur.");
		return "hello";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/post/{id}")
	public String getById(@PathVariable("id") int id, Model model) {
		Post truc = postService.getById(id);
		model.addAttribute("error", "C'est toi l'erreur d'ID : "+ truc.getContent());

		List<Post> truc2 = postService.getAll();

		model.addAttribute("prods", truc2);
		
		return "hello";
	}
}
