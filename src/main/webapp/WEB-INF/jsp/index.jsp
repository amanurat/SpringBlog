<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.2/css/bootstrap.min.css" />
<title>myBlog</title>

<script type="text/template" id="show-posts-template">
<a href="#/new" class="btn btn-primary">New Post</a> 
<table class="table striped">
	<thead>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Contnet</th>
			<th>Visible</th>
			<th>Date</th>
		</tr>
	</thead>
	<tbody>
		<@ _.each(posts, function(post){ @>
			 <tr>
				<td><@= post.get('id') @></td>
				<td><@= post.get('title') @></td>
				<td><@= post.get('content') @></td>
				<td><@= post.get('visible') @></td>
				<td><@= new Date(post.get('date')) @></td>
			</tr>
		<@ }); @>
	</tbody>
</table>
</script>

<script type="text/template" id="edit-post-template">
	<form role="form" class="edit-post-form">
		<legend>Create Post</legend>
		<label>Title</label>
		<input type="text" name="title" class="form-control"/>
		<label>Visable</label>
		<select class="form-control" name="isVisible">
  			<option>false</option>
  			<option>true</option>
		</select>
		<label>Content</label>
		<textarea rows="16" name="content" class="form-control"></textarea>
		<hr />
		<button type="submit" class="btn">Create Post</button>
	</form>
</script>

</head>
<body>
	<div class="container">
		<h1><a href="index">Blog Manager</a></h1>
		<hr />
		<div class="page"></div>
	</div>
	

<br />
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/backbone.js/1.1.0/backbone-min.js"></script>



<script>
	//configure underscore to work with jsp
	_.templateSettings = {
		    interpolate: /\<\@\=(.+?)\@\>/gim,
		    evaluate: /\<\@([\s\S]+?)\@\>/gim,
		    escape: /\<\@\-(.+?)\@\>/gim
	};

	//helper function to serialize objects
	function htmlEncode(value){
	    return $('<div/>').text(value).html();
	  }
	  $.fn.serializeObject = function() {
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	        if (o[this.name] !== undefined) {
	            if (!o[this.name].push) {
	                o[this.name] = [o[this.name]];
	            }
	            o[this.name].push(this.value || '');
	        } else {
	            o[this.name] = this.value || '';
	        }
	    });
	    return o;
	  };

	//get collection from RESTful service
	var Posts = Backbone.Collection.extend({
		url: '/blog/admin/allPosts'
	});
	
	//Creating model
	var Post = Backbone.Model.extend({
		urlRoot: '/blog/admin/addNewPost'
	});

	//View Configuration
	var PostListView = Backbone.View.extend({
		el: '.page',
		render: function(){
			var that = this;
			var posts = new Posts();
			posts.fetch({
				success: function(posts){
					var template = _.template($('#show-posts-template').html(),{posts: posts.models});
					that.$el.html(template);
				}
			});
		}
	});
	
	var EditPostView = Backbone.View.extend({
		el: '.page',
		render:  function(){
			var template = _.template($('#edit-post-template').html(),{});
			this.$el.html(template);
		},
		events: {
			'submit .edit-post-form': 'savePost'
		},
		savePost: function(ev){
			var postDetails = $(ev.currentTarget).serializeObject();
			var post = new Post();
			post.save(postDetails, {
				success: function(post, resonse){
					console.log("ok");
					//router.navigate('',{trigger: true});
				},
				error: function(postDetials, response){
					console.log("error");
					router.navigate('',{trigger: true});
				},
			});
			return false;
		}
		
	});

	//Router Configuration
	var Router = Backbone.Router.extend({
		routes: {
			'': 'homeView',
			'new': 'editPostView'
		}
	});
	
	
	var router = new Router;
	var postListView = new PostListView();
	var editPostView = new EditPostView();
	
	
	router.on('route:homeView', function(){
		postListView.render();
	});
	router.on('route:editPostView', function(){
		editPostView.render();
	});
	
	Backbone.history.start();
	
</script>
</body>
</html>