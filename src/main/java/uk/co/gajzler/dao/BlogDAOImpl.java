package uk.co.gajzler.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uk.co.gajzler.domain.BlogPost;

@Repository
public class BlogDAOImpl implements BlogDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public void addPost(BlogPost blogPost) {
		sessionFactory.getCurrentSession().save(blogPost);
	}

	public List<BlogPost> getAllPosts() {
		return sessionFactory.getCurrentSession().createQuery("from BlogPost ORDER BY id DESC").list();
	}

	public BlogPost getPostById(int id) {
		return (BlogPost)sessionFactory.getCurrentSession().get(BlogPost.class, id);
	}
	
}
