package uk.co.gajzler.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uk.co.gajzler.domain.BlogPost;

public class MockDB {

	private static MockDB instance;
	private List<BlogPost> posts;
	
	MockDB(){
		posts = new ArrayList<BlogPost>();
		addMockData();
	}
	
	public static MockDB getInstance(){
		if(instance == null)
			instance =  new MockDB();
		return instance;
	}
	
	private void addMockData(){
		BlogPost bp = new BlogPost();
		bp.setId(1);
		bp.setDate(new Date());
		bp.setTitle("This is my first post and title");
		bp.setContent("This is conntent provide for this great post if you dont like it then sorry :");
		posts.add(bp);
		
		bp = new BlogPost();
		bp.setId(2);
		bp.setDate(new Date());
		bp.setTitle("Post no. 2");
		bp.setContent("Welcome back to my second post, i hope you enjoy the last one :P");
		posts.add(bp);
		
		bp = new BlogPost();
		bp.setId(3);
		bp.setDate(new Date());
		bp.setTitle("XMas Comming");
		bp.setContent("I don't know what to write so I stop here");
		posts.add(bp);
	}
	
	public List<BlogPost> getPosts(){
		return posts;
	}
	
	public void addPost(BlogPost bp){
		posts.add(bp);
	}
	
	public BlogPost getPostById(int id) {
		
		for(BlogPost bp : posts){
			if(bp.getId() == id)
				return bp;
		}
		return null;
		
	}
}
