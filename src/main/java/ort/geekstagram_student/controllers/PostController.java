package ort.geekstagram_student.controllers;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
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
import org.thymeleaf.expression.Lists;

import ort.geekstagram_student.entities.Like;
import ort.geekstagram_student.entities.Post;
import ort.geekstagram_student.entities.User;
import ort.geekstagram_student.likes.service.ILikeService;
import ort.geekstagram_student.posts.service.IPostService;
import ort.geekstagram_student.user.service.IUserService;

@Controller
public class PostController {

	@Autowired
	@Qualifier("MySQLPostService")
	private IPostService postService;
	@Autowired
	@Qualifier("MySQLLikeService")
	private ILikeService likeService;
	@Autowired
	@Qualifier("MySQLUserService")
	private IUserService userService;

	/**
	 * Méthode pour récupérer tous les posts existant actuellement dans la base
	 * de données.
	 * 
	 * @param model
	 *            va permettre de transmettre les données du contrôleur à la vue
	 *            "posts".
	 * @return la page posts
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/posts")
	public String index(Model model) {
		List<Post> posts = postService.getAll();
		Map<Post, HashMap<Integer, Integer>> posts_comments = new HashMap<Post, HashMap<Integer, Integer>>();
		for (Iterator<Post> i = posts.iterator(); i.hasNext();) {
			Post item = i.next();
			List<Post> comments = postService.getAllComments((int) item.getId());
			List<Like> likes = likeService.getAllLikesByPost((int) item.getId());

			HashMap<Integer, Integer> coms_likes = new HashMap<Integer, Integer>();
			coms_likes.put(comments.size(), likes.size());

			posts_comments.put(item, coms_likes);
		}
		model.addAttribute("posts", posts);
		model.addAttribute("posts_comments", posts_comments);

		model.addAttribute("error", "C'est toi l'erreur.");
		return "posts";
	}

	/**
	 * Méthode pour récupérer un post en particulier, à partir de son ID.
	 * 
	 * @param id
	 *            récupérée depuis le paramètre id de la requête GET
	 * @param model
	 *            va permettre de transmettre les données du contrôleur à la vue
	 *            "posts".
	 * 
	 * @return la page du post correspondant
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/post/{id}")
	public String getById(@PathVariable("id") int id, Model model, HttpSession session) {
		Post post = postService.getById(id);
		List<Post> comments = postService.getAllComments(id);
		List<User> users = (List<User>) userService.GetAll();	
		Map<Post, String> commentsAuthor = new HashMap<Post, String>();
		
		User postAuthor = userService.Get(post.getUserId());
		Like like = likeService.getById(id, (int) ((User) session.getAttribute("user")).getId());

		boolean isAlreadyLiked = like == null ? false : true;
		

		for (Iterator<Post> i = comments.iterator(); i.hasNext();) {
			Post item = i.next();
			User author = userService.Get(item.getUserId());
			if (author != null) {
				commentsAuthor.put(item, author.getName());
			}
		}


		model.addAttribute("comments", comments);
		model.addAttribute("commentsAuthor", commentsAuthor);
		model.addAttribute("post", post);
		model.addAttribute("liked", isAlreadyLiked);
		model.addAttribute("author", postAuthor.getName());

		return "post";
	}

	/**
	 * Méthode pour ouvrir la page où l'on pourra saisir le nouveau post.
	 * 
	 * @return la page de saisie d'un nouveau post
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/newpost")
	public String insertPost() {
		return "newPost";
	}

	/**
	 * Méthode pour ajouter un nouveau post dans la base de données. La date
	 * courante sera récupérée pour son insertion.
	 * 
	 * @param title
	 *            titre du post
	 * @param content
	 *            contenu des posts
	 * @param model
	 *            va permettre de transmettre les données du contrôleur à la vue
	 *            "posts".
	 * @param session
	 *            variable de session.
	 * @return la page du nouveau post créé.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/addpost")
	public String addPost(@RequestParam("title") String title, @RequestParam("content") String content, Model model,
			HttpSession session) {

		int dateToInsert = (int) ((new Date()).getTime());

		session.setAttribute("userId", 14);

		Post newPost = new Post(title, content, dateToInsert, (int) ((User) session.getAttribute("user")).getId());
		postService.add(newPost);

		model.addAttribute("post", newPost);
		return "redirect:/post/" + newPost.getId();
	}

	/**
	 * Suppression d'un post
	 * 
	 * @param id
	 *            id du post à supprimer
	 * @return page de tous les posts
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/deletepost")
	public String deletePost(@RequestParam("id") long id) {
		Post newPost = postService.getById(id);
		postService.remove(newPost.getId());

		return "redirect:/posts";
	}

	/**
	 * Ouverture de la page où l'on pourra modifier dans un éditeur de texte le
	 * contenu des posts.
	 * 
	 * @param id
	 *            id du post à modifier
	 * @param model
	 *            va permettre de transmettre les données du contrôleur à la vue
	 *            "posts".
	 * 
	 * @return la page postToUpdate
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/posttoupdate/{id}")
	public String posttoupdate(@PathVariable("id") int id, Model model) {
		Post postToUpdate = postService.getById(id);

		model.addAttribute("post", postToUpdate);

		return "postToUpdate";
	}

	/**
	 * Modification effective dans la base de données du post
	 * 
	 * @param id
	 *            id du post à modifier
	 * @param content
	 *            contenu du post modifié
	 * @param title
	 *            titre du post modifié
	 * @return la page du post modifié
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/updatepost")
	public String updatePost(@RequestParam("id") String id, @RequestParam("content") String content,
			@RequestParam("title") String title) {
		int trueID = Integer.parseInt(id);
		Post postToUpdate = postService.getById(trueID);

		postToUpdate.setContent(content);
		postToUpdate.setTitle(title);

		postService.update(trueID, postToUpdate);

		return "redirect:/post/" + trueID;
	}

	/**
	 * Ajout de commentaire à un post existant.
	 * 
	 * @param id
	 *            id du post sur lequel il faut rattacher le commentaire.
	 * @param content
	 *            contenu du commentaire.
	 * @param title
	 *            titre du commentaire.
	 * @param model
	 *            va permettre de transmettre les données du contrôleur à la vue
	 *            "posts".
	 * @param session
	 *            variable de session.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/addcomment")
	public String addComment(@RequestParam("id") String id, @RequestParam("content") String content,
			@RequestParam("title") String title, Model model, HttpSession session) {
		int postID = Integer.parseInt(id);

		int dateToInsert = (int) (System.currentTimeMillis());

		Post newComment = new Post(title, content, dateToInsert, (int) ((User) session.getAttribute("user")).getId(), postID);
		postService.add(newComment);

		model.addAttribute("post", postService.getById(postID));

		return "redirect:/post/" + postID;
	}
}
