/**
 * 
 */
package ort.geekstagram_student.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Severin
 * @version 1.0
 * 
 */
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String mail;
	
	@NotNull
	private String password;
	
	public long getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getMail(){
		return mail;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setName(String username){
		this.name = username;
	}
	
	public void setMail(String mail){
		this.mail = mail;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public User(){
		super();
	}
	
	public User(String username, String mail, String password){
		super();
		this.name = username;
		this.mail = mail;
		this.password = password;
	}
}
