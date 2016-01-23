package ort.geekstagram_student.likes.repository;

import org.springframework.data.repository.CrudRepository;

import ort.geekstagram_student.entities.Like;

public interface ILikeRepository extends CrudRepository<Like, Long> {

}
