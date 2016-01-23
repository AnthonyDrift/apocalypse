package ort.geekstagram_student.entities;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ort.geekstagram_student.user.service.IUserService;

@Entity
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private String title;

	@NotNull
	private String content;

	@NotNull
	private long date;

	@NotNull
	@Column(name = "iscomment")
	private boolean isComment;

	@NotNull
	@Column(name = "iscommentof")
	private int isCommentOf;

	// rajouter @Column(name="userid") car sinon l'API va aller chercher user_id
	// à cause de la notation CAML
	@NotNull
	@Column(name = "userid")
	private long userId;

	public Post() {
		super();
	}

	public Post(String title, String content, long date, long userId) {
		super();
		this.title = title;
		this.content = content;
		this.date = date;
		this.userId = userId;
	}

	public Post(String title, String content, long date, long userId, int idPost) {
		super();
		this.title = title;
		this.content = content;
		this.date = date;
		this.userId = userId;
		this.isComment = true;
		this.isCommentOf = idPost;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public long getDate() {
		return date;
	}

	public long getUserId() {
		return userId;
	}

	public long getPostId() {
		return isCommentOf;
	}

	public boolean getIsComment() {
		return isComment;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setIsCommentOf(int isCommentOf) {
		this.isCommentOf = isCommentOf;
	}

	public String convertTime() {
		Date date = new Date(this.date * 1000);
		Format format = new SimpleDateFormat("dd/MM/yyyy à HH:mm:ss");
		return format.format(date);
	}
}
