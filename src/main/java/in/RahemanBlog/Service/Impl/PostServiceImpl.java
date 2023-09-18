package in.RahemanBlog.Service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.validator.internal.constraintvalidators.bv.notempty.NotEmptyValidatorForArraysOfLong;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.RahemanBlog.Entity.Category;
import in.RahemanBlog.Entity.Post;
import in.RahemanBlog.Entity.User;
import in.RahemanBlog.Payloads.PostDto;
import in.RahemanBlog.Repository.PostRepo;
import in.RahemanBlog.Repository.UserRepo;
import in.RahemanBlog.Repository.categoryRepo;
import in.RahemanBlog.Service.PostService;
import in.RahemanBlog.sException.ResourceNotFoundExcption;

@Service
public class PostServiceImpl implements PostService {

	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private categoryRepo catRepo;
	
	
	//in create post we have to fetch post data, what is category of post, what is user of that post means who posted by user

	//http://localhost:8080/api/user/5/category/13/post
	@Override
	public PostDto createPost(PostDto dto, Integer userId, Integer catId) {
		
		
		User userData = userRepo.findById(userId).orElseThrow(
				() -> new ResourceNotFoundExcption("user", "userId", userId));
		
	    Category categoryData = catRepo.findById(catId).orElseThrow( 
		         () -> new ResourceNotFoundExcption("category", "categoryId", catId));
	    
	    
		Post post = mapper.map(dto, Post.class);
				
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		
		post.setUser(userData);
		post.setCategory(categoryData);
		
		
		Post newPost = postRepo.save(post);
		
		return mapper.map(newPost, PostDto.class);
	}

	
	//update Post
	
	@Override
	public PostDto updatePost(PostDto dto, Integer id) {
		
		Post updatePost = postRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundExcption("post", "postId", id));
		
		updatePost.setTitle(dto.getTitle());
		updatePost.setContent(dto.getContent());

		Post updPost = postRepo.save(updatePost);
		
		return mapper.map(updPost, PostDto.class);
	}
	
	//delete Post

	@Override
	public void DeletePost(Integer id) {
         
		Post deletePost = postRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundExcption("post", "postId", id)
		);
		
		postRepo.delete(deletePost);
	}

	
	// get All Posts
	
	@Override
	public List<PostDto> getAllPosts() {
		
		List<Post> allPost = postRepo.findAll();
		
		ArrayList<PostDto> dtoArr = new ArrayList<>();
		
		for(Post postData : allPost) {
			dtoArr.add(mapper.map(postData, PostDto.class));
		}
		
		return dtoArr;
	}

	
	
	//get single post by id
	
	@Override
	public PostDto getPostById(Integer id) {
		
		Post postId = postRepo.findById(id).orElseThrow(
		           () -> new ResourceNotFoundExcption("post", "postId", id));
		
		Post getOnePost = postRepo.save(postId);
		
		return mapper.map(getOnePost, PostDto.class);
	}
	
	

	//get all posts by calling category id, bcoz 1 category having multiple posts,
	//so our tast is to call by using 1 category to call all post which is on category id
	
	@Override
	public List<PostDto> getAllPostByCategoryId(Integer id) {
		
		Category categorys = catRepo.findById(id).orElseThrow(
		           () -> new ResourceNotFoundExcption("category", "catId", id));
		
		List<Post> postData = postRepo.findByCategory(categorys);
		
		ArrayList<PostDto> dtoArr = new ArrayList<>();
		
		for(Post posts : postData) {
			dtoArr.add(mapper.map(posts, PostDto.class));
		}
		
		return dtoArr;
		
	}

	
	//get all posts by using user Id
	
	@Override
	public List<PostDto> getAllPostsByUserId(Integer id) {
		
		User userId = userRepo.findById(id).orElseThrow(
				  () -> new ResourceNotFoundExcption("user", "userId", id));
		
		List<Post> userData = postRepo.findByUser(userId);
		
		ArrayList<PostDto> dtoArr = new ArrayList<>();
		
		for(Post data : userData) {
			dtoArr.add(mapper.map(data, PostDto.class));
		}
		
		return dtoArr;
	}
	

	
	@Override
	public List<Post> searchAllPosts(String keyword) {
		return null;
	}

}
