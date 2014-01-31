package uk.co.gajzler.dao;

import java.util.List;
import uk.co.gajzler.domain.BlogPost;

public interface BlogDAO {
	public void addPost(BlogPost blogPost);
	public List<BlogPost> getAllPosts();
	public BlogPost getPostById(int id);
}
