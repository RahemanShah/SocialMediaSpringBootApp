package in.RahemanBlog.Service;

import java.util.List;

import in.RahemanBlog.Entity.Post;
import in.RahemanBlog.Payloads.PostDto;

public interface PostService {

	
	// create post
	public PostDto createPost(PostDto dto, Integer userId, Integer catId);
	
	

	// update post
	public PostDto updatePost(PostDto dto, Integer id);
	
	// delete post
	public void DeletePost(Integer id);

	// get all posts
	public List<PostDto> getAllPosts();

	// get one post
	public PostDto getPostById(Integer id);
	
	

	// get all posts by categoryId
	public List<PostDto> getAllPostByCategoryId(Integer id);
	
	//get all post by user
	public List<PostDto> getAllPostsByUserId(Integer id);
	
	//search post by keyword
	public List<Post> searchAllPosts(String keyword);
	
	

}
