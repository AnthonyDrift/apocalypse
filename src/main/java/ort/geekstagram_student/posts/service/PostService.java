package ort.geekstagram_student.posts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ort.geekstagram_student.entities.Post;

@Component
@Qualifier("FakePostService")
public class PostService implements IPostService{

	public static List<Post> liste = new ArrayList<Post>();
	private static long id = 0;
	
	@Override
	public void add(Post com){
		id++;
		com.setId(id);
		liste.add(com);
	}

	@Override
	public List<Post> getAll(){
		return liste;
	}

	@Override
	public Post getById(long id){
		for(Post ce : liste ) {
		    if (ce.getId() == id){
		    	return ce;
		    }
		}
		return null;
	}

	@Override
	public Post update(long id, Post entity){
		Post entity_Res = this.getById(id);
		
		if (entity_Res != null){
			entity_Res.setContent(entity.getContent());
			entity_Res.setDate(entity.getDate());
		}
		
		return entity_Res;
	}

	@Override
	public void remove(long id){
		liste.remove(this.getById(id));
	}

	@Override
	public Post getByUserId(long userId) {
		for(Post ce : liste ) {
		    if (ce.getId() == userId){
		    	return ce;
		    }
		}
		return null;
	}
}
