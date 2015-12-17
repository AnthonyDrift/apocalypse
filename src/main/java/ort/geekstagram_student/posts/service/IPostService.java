package ort.geekstagram_student.posts.service;
import ort.geekstagram_student.entities.Post;

import java.util.List;

public interface IPostService {
	public void add(Post com);
	public List<Post> getAll();
	public Post getById(long id);
	public Post update(long id, Post entity);
	public Post getByUserId(long userId);
	public void remove(long id);
}
