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
	private long Id;
	
	@NotNull
	private String Name;
	
	@NotNull
	private String Mail;
	
	@NotNull
	private String Password;
	
	public long Id(){
		return Id;
	}
	
	public String Name(){
		return Name;
	}
	
	public String Mail(){
		return Mail;
	}
	
	public String Password(){
		return Password;
	}
	
	public void SetName(String username){
		this.Name = username;
	}
	
	public void SetMail(String mail){
		this.Mail = mail;
	}
	
	public void SetPassword(String password){
		this.Password = password;
	}
	
	public User(){
		super();
	}
	
	public User(String username, String mail, String password){
		super();
		this.Name = username;
		this.Mail = mail;
		this.Password = password;
	}
}
