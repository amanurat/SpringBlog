package uk.co.gajzler.service;

import java.util.List;

import uk.co.gajzler.domain.BlogPost;

public interface BlogService {
	public void addPost(BlogPost blogPost);
	public List<BlogPost> getAllPosts();
	public BlogPost getPostById(int id);
}
