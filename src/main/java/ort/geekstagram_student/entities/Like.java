package ort.geekstagram_student.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "likes")
public class Like {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	@Column(name = "idpost")
	private int idPost;

	@NotNull
	@Column(name = "iduser")
	private int idUser;

	@NotNull
	@Column(name = "likedate")
	private int likeDate;

	public Like() {
		super();
	}

	public Like(int idPost, int idUser, int likeDate) {
		super();
		this.idPost = idPost;
		this.idUser = idUser;
		this.likeDate = likeDate;
	}

	public int getIdPost() {
		return idPost;
	}

	public int getIdUser() {
		return idUser;
	}

	public int getLikeDate() {
		return likeDate;
	}

	public long getId() {
		return id;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public void setUserId(int idUser) {
		this.idUser = idUser;
	}

	public void setLikeDate(int likeDate) {
		this.likeDate = likeDate;
	}

	public void setId(long id) {
		this.id = id;
	}
}
