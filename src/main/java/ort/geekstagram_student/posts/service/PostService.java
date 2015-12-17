package ort.geekstagram_student.posts.service;

import java.util.ArrayList;
import java.util.List;

import ort.geekstagram_student.posts.PostEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("FakePostService")
public class PostService implements IPostService{

	public static List<PostEntity> liste = new ArrayList<PostEntity>();
	private static long id = 0;
	
	@Override
	public void add(PostEntity com){
		id++;
		com.setId(id);
		liste.add(com);
	}

	@Override
	public List<PostEntity> getAll(){
		return liste;
	}

	@Override
	public PostEntity getById(long id){
		for(PostEntity ce : liste ) {
		    if (ce.getId() == id){
		    	return ce;
		    }
		}
		return null;
	}

	@Override
	public PostEntity update(long id, PostEntity entity){
		PostEntity entity_Res = this.getById(id);
		
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
	public PostEntity getByUserId(long userId) {
		for(PostEntity ce : liste ) {
		    if (ce.getId() == userId){
		    	return ce;
		    }
		}
		return null;
	}
}
