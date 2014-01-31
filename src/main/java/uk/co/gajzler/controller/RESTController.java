package uk.co.gajzler.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import uk.co.gajzler.domain.BlogPost;
import uk.co.gajzler.service.BlogService;

@Controller
@RequestMapping("admin")
public class RESTController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value="show/{id}", method=RequestMethod.GET)
	@ResponseBody
	public BlogPost getPostById(@PathVariable int id){
		System.out.println(id);
		return blogService.getPostById(id);
	}
	
	@RequestMapping(value="allPosts", method=RequestMethod.GET)
	@ResponseBody
	public List<BlogPost> getAllPosts(){
		return blogService.getAllPosts();
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public BlogPost deletePostWithId(@PathVariable int id){
		System.out.println("Deleta Post with ID");
		return null;
	}
	

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value="addNewPost", method=RequestMethod.POST)
	public void addNewPost(@RequestBody BlogPost blogPost){
		blogPost.setDate(new Date());
		blogService.addPost(blogPost);
	}
	
}
