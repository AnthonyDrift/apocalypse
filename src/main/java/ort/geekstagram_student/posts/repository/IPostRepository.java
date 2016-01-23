package ort.geekstagram_student.posts.repository;

import org.springframework.data.repository.CrudRepository;

import ort.geekstagram_student.entities.Post;

public interface IPostRepository extends CrudRepository<Post, Long>  {
	Post findByTitle(String title);
}
