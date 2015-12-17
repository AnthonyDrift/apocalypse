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
@Table(name = "comment")
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
	
	public long GetId(){
		return Id;
	}
	
	public String GetName(){
		return Name;
	}
	
	public String GetMail(){
		return Mail;
	}
	
	public String GetPassword(){
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
