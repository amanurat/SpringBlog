package uk.co.gajzler.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="BLOGPOST")
public class BlogPost implements Serializable{
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private int id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="CONTENT")
	@Type(type="text")
	private String content;
	
	@Column(name="DATE")
	private Date date;
	
	@Column(name="VISIBLE")
	private boolean isVisible;
	
	public BlogPost(){}
	
	public BlogPost(int id, String title, String content, Date date){
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
	}
	
	public BlogPost(String title, String content){
		this.title = title;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isVisible() {
		return isVisible;
	}

	public void setIsVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
}
