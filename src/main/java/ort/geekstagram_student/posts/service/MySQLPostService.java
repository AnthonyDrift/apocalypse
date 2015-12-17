package ort.geekstagram_student.posts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ort.geekstagram_student.posts.PostEntity;
import ort.geekstagram_student.posts.repository.IPostRepository;

@Component
@Qualifier("MYSQLPostService")
public class MySQLPostService implements IPostService {

	@Autowired
	IPostRepository repository;
	
	@Override
	public void add(PostEntity com) {
		repository.save(com);
	}

	@Override
	public List<PostEntity> getAll() {
		List<PostEntity> resList = new ArrayList<PostEntity>();
		Iterable<PostEntity> temp = repository.findAll();
		for(PostEntity ce : temp ) {
			resList.add(ce);
		}
		return resList;
	}

	@Override
	public PostEntity getById(long id) {
		return repository.findOne(id);
	}

	@Override
	public PostEntity update(long id, PostEntity entity) {
		entity.setId(id);
		return repository.save(entity);
	}

	@Override
	public void remove(long id) {
		repository.delete(id);
	}

	@Override
	public PostEntity getByUserId(long userId) {
		return repository.findOne(userId);
	}
}
