package ort.geekstagram_student.likes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ort.geekstagram_student.entities.Like;

@Component
@Qualifier("FakeLikeService")
public class LikeService implements ILikeService {

	public static List<Like> liste = new ArrayList<Like>();
	private static long id = 0;

	@Override
	public void add(Like Like) {
		id++;
		Like.setId(id);
		liste.add(Like);
	}

	@Override
	public List<Like> getAll() {
		return liste;
	}

	@Override
	public Like getById(int idPost, int idUser) {
		for (Like li : liste) {
			if ((li.getIdPost() == idPost) && (li.getIdUser() == idUser)) {
				return li;
			}
		}
		return null;
	}

	@Override
	public void remove(int idPost, int idUser) {
		for (Like li : liste) {
			if ((li.getIdPost() == idPost) && (li.getIdUser() == idUser)) {
				liste.remove(li);
			}
		}
	}

	@Override
	public Like getByUserId(long userId) {
		for (Like li : liste) {
			if (li.getIdUser() == userId) {
				return li;
			}
		}
		return null;
	}

	@Override
	public List<Like> getAllLikesByPost(int idPost) {
		List<Like> listeLike = new ArrayList<Like>();
		for (Like li : liste) {
			if (li.getIdPost() == idPost) {
				listeLike.add(li);
			}
		}
		return listeLike;
	}
}
