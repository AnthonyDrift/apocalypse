package ort.geekstagram_student.posts.service;

import java.util.List;

import ort.geekstagram_student.entities.Post;

public interface IPostService {
	public void add(Post com);

	public List<Post> getAll();

	public List<Post> getAllComments(int id);

	public Post getById(long id);

	public Post update(long id, Post entity);

	public Post getByUserId(long userId);

	public void remove(long id);
	
	public List<Post> getAllPostByUser(long userId);
}
