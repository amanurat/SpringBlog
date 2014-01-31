package uk.co.gajzler.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import uk.co.gajzler.domain.BlogPost;

@Repository
public class BlogDAOMock implements BlogDAO{

	private MockDB db;
	
	public BlogDAOMock(){
		db = MockDB.getInstance();
	}
	
	public void addPost(BlogPost blogPost) {
		db.addPost(blogPost);
	}

	public List<BlogPost> getAllPosts() {
		return db.getPosts();
	}

	public BlogPost getPostById(int id) {
		return db.getPostById(id);
	}

}
