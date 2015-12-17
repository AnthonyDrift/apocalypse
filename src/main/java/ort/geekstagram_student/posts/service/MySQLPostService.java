package ort.geekstagram_student.posts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ort.geekstagram_student.entities.Post;
import ort.geekstagram_student.posts.repository.IPostRepository;

@Component
@Qualifier("MYSQLPostService")
public class MySQLPostService implements IPostService {

	@Autowired
	IPostRepository repository;
	
	@Override
	public void add(Post com) {
		repository.save(com);
	}

	@Override
	public List<Post> getAll() {
		List<Post> resList = new ArrayList<Post>();
		Iterable<Post> temp = repository.findAll();
		for(Post ce : temp ) {
			resList.add(ce);
		}
		return resList;
	}

	@Override
	public Post getById(long id) {
		return repository.findOne(id);
	}

	@Override
	public Post update(long id, Post entity) {
		entity.setId(id);
		return repository.save(entity);
	}

	@Override
	public void remove(long id) {
		repository.delete(id);
	}

	@Override
	public Post getByUserId(long userId) {
		return repository.findOne(userId);
	}
}
