package ort.geekstagram_student.posts.repository;

import ort.geekstagram_student.posts.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface IPostRepository extends CrudRepository<PostEntity, Long>  {

}
