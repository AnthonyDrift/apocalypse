/**
 * 
 */
package ort.geekstagram_student.user.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ort.geekstagram_student.entities.User;
import ort.geekstagram_student.user.repository.IUserRepository;

/**
 * @author Severin
 * @version 1.0
 */

@Component
@Qualifier("MySQLUserService")
public class MySQLUserService implements IUserService{

	@Autowired
	IUserRepository repository;
	
	@Override
	public User Add(User user) {
		return repository.save(user);	
	}

	@Override
	public Iterable<User> GetAll() {
		return repository.findAll();
	}
	
	@Override
	public User GetByName(String name)
	{
		try{
			return repository.findByName(name);
		}
		catch(Exception ex){
			return null;
		}
	}
	
	@Override
	public User GetByMail(String mail)
	{
		try{
			return repository.findByMail(mail);
		}
		catch(Exception ex){
			return null;
		}
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
		
		userToUpdate.setName(user.getName());
		userToUpdate.setMail(user.getMail());
		userToUpdate.setPassword(user.getPassword());
		
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
