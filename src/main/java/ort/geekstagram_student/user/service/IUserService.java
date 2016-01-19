/**
 * 
 */
package ort.geekstagram_student.user.service;

import ort.geekstagram_student.entities.User;

/**
 * @author Severin
 * @version 1.0
 */
public interface IUserService {
	public User Add(User user);
	public Iterable<User> GetAll();
	public User Get(long id);
	public boolean Update(long id, User user);
	public boolean Remove(long id);
	public User GetByName(String name);
	public User GetByMail(String mail);
}
