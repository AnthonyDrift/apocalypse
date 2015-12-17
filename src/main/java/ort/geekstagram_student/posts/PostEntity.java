package ort.geekstagram_student.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "posts")
public class PostEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private String content;

	@NotNull
	private long date;

	//rajouter @Column(name="userid") car sinon l'API va aller chercher user_id à cause de la notation CAML
	@NotNull
	@Column(name="userid")
	private long userId;

	public PostEntity() {
		super();
	}

	public PostEntity(String content, long date, long userId) {
		super();
		this.content = content;
		this.date = date;
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getUserId() {
		return userId;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
