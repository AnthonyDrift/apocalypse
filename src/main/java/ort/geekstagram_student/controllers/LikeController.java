package ort.geekstagram_student.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import ort.geekstagram_student.entities.Like;
import ort.geekstagram_student.likes.service.ILikeService;

@Controller
public class LikeController {

	@Autowired
	@Qualifier("MySQLLikeService")
	private ILikeService likeService;

	/**
	 * Ajout d'un Like au post s'il n'est pas encore aimé.
	 * 
	 * @param idPost
	 *            id du post aimé
	 * @param model
	 *            va permettre de transmettre les données du contrôleur à la vue
	 *            "posts".
	 * @param session
	 *            variable de session.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/like")
	@ResponseStatus(value = HttpStatus.OK)
	public void likePost(@RequestParam("idPost") int idPost, Model model, HttpSession session) {
		int dateToInsert = (int) (new Date()).getTime();

		session.setAttribute("userId", 14);

		Like likeExiste = likeService.getById(idPost, (int) session.getAttribute("userId"));

		if (likeExiste == null) {
			Like newPost = new Like(idPost, (int) session.getAttribute("userId"), dateToInsert);
			likeService.add(newPost);
		}
	}

	/**
	 * Suppression d'un like déjà donné à un post.
	 * 
	 * @param idPost
	 *            id du post à désaimer.
	 * @param model
	 *            va permettre de transmettre les données du contrôleur à la vue
	 *            "posts".
	 * @param session
	 *            variable de session.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/unlike")
	@ResponseStatus(value = HttpStatus.OK)
	public void unlikePost(@RequestParam("idPost") int idPost, Model model, HttpSession session) {
		session.setAttribute("userId", 14);

		likeService.remove(idPost, (int) session.getAttribute("userId"));
	}
}
