package ort.geekstagram_student.posts.service;

import java.util.List;

import ort.geekstagram_student.posts.PostEntity;

public interface IPostService {
	public void add(PostEntity com);
	public List<PostEntity> getAll();
	public PostEntity getById(long id);
	public PostEntity update(long id, PostEntity entity);
	public PostEntity getByUserId(long userId);
	public void remove(long id);
}
