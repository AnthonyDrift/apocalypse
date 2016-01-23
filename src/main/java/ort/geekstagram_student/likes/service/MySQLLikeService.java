package ort.geekstagram_student.likes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ort.geekstagram_student.entities.Like;
import ort.geekstagram_student.likes.repository.ILikeRepository;

@Component
@Qualifier("MySQLLikeService")
public class MySQLLikeService implements ILikeService {

	@Autowired
	ILikeRepository repository;

	@Override
	public void add(Like like) {
		repository.save(like);
	}

	@Override
	public List<Like> getAll() {
		List<Like> resList = new ArrayList<Like>();
		Iterable<Like> temp = repository.findAll();
		for (Like li : temp) {
			resList.add(li);
		}
		return resList;
	}

	@Override
	public List<Like> getAllLikesByPost(int idPost) {
		List<Like> resList = new ArrayList<Like>();
		Iterable<Like> temp = repository.findAll();
		for (Like li : temp) {
			if ((li.getIdPost() == idPost)) {
				resList.add(li);
			}
		}
		return resList;
	}

	@Override
	public Like getById(int idPost, int idUser) {
		Iterable<Like> temp = repository.findAll();
		for (Like li : temp) {
			if ((li.getIdPost() == idPost) && (li.getIdUser() == idUser)) {
				return li;
			}
		}
		return null;
	}

	@Override
	public void remove(int idPost, int idUser) {
		Iterable<Like> temp = repository.findAll();
		for (Like li : temp) {
			if ((li.getIdPost() == idPost) && (li.getIdUser() == idUser)) {
				repository.delete(li);
			}
		}
	}

	@Override
	public Like getByUserId(long userId) {
		return repository.findOne(userId);
	}
}
