package ort.geekstagram_student.user.repository;

import org.springframework.data.repository.CrudRepository;

import ort.geekstagram_student.entities.User;

public interface IUserRepository extends CrudRepository<User, Long>{

}
