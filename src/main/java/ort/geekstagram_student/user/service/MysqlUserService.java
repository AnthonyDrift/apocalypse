/**
 * 
 */
package ort.geekstagram_student.user.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ort.geekstagram_student.entities.User;
import ort.geekstagram_student.user.repository.ICommentRepository;

/**
 * @author Severin
 * @version 1.0
 */

@Component
@Qualifier("MysqlUserService")
public class MysqlUserService implements IUserService{

	@Autowired
	ICommentRepository repository;
	
	@Override
	public User Add(User user) {
		return repository.save(user);	
	}

	@Override
	public Iterable<User> GetAll() {
		return repository.findAll();
	}
	
	/* Throws Exception when id is null */
	@Override
	public User Get(long id) {
		try{
			return repository.findOne(id);
		}
		catch(Exception ex){
			return null;
		}
	}
	
	/* Returns true if update succeeds or false */
	@Override
	public boolean Update(long id, User user) {
		User userToUpdate = this.Get(id);
		
		if(userToUpdate == null)
			return false;
		
		userToUpdate.SetName(user.GetName());
		userToUpdate.SetMail(user.GetMail());
		userToUpdate.SetPassword(user.GetPassword());
		
		if(repository.save(userToUpdate) == userToUpdate)
			return true;
		return false;
	}

	/* Returns true if remove succeeds or false */
	@Override
	public boolean Remove(long id) {
		try{
			repository.delete(id);
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}

}
