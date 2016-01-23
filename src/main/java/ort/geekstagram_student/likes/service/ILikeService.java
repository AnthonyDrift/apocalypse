package ort.geekstagram_student.likes.service;

import java.util.List;

import ort.geekstagram_student.entities.Like;

public interface ILikeService {

	public void add(Like com);

	public List<Like> getAll();

	public List<Like> getAllLikesByPost(int idPost);

	public Like getById(int idPost, int idUser);

	public Like getByUserId(long userId);

	public void remove(int idPost, int idUser);
}
