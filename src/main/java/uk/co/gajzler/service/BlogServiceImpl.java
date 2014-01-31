package uk.co.gajzler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uk.co.gajzler.dao.BlogDAO;
import uk.co.gajzler.domain.BlogPost;

@Service
@Transactional
public class BlogServiceImpl implements BlogService{

	@Autowired
	@Qualifier("blogDAOImpl")
	private BlogDAO blogDAO;
	
	public void addPost(BlogPost blogPost) {
		blogDAO.addPost(blogPost);
	}

	public List<BlogPost> getAllPosts() {
		return blogDAO.getAllPosts();
	}

	public BlogPost getPostById(int id) {
		return blogDAO.getPostById(id);
	}

}
