package in.RahemanBlog.sRestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.RahemanBlog.Payloads.PostDto;
import in.RahemanBlog.Service.PostService;

@RestController
@RequestMapping("/api")
public class PostRestController {

	@Autowired
	private PostService service;
	
	
	@PostMapping("/user/{userId}/category/{catId}/post")
	private ResponseEntity<PostDto> cretePost(
			
			@RequestBody PostDto dto, 
			@PathVariable Integer userId, 
			@PathVariable Integer catId
			)
	{
		
		PostDto createPost = service.createPost(dto, userId, catId);
		
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/getPost/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer id){
		
		PostDto postById = service.getPostById(id);
		return new ResponseEntity<PostDto>(postById, HttpStatus.OK);
	}
	
	
	@GetMapping("/allPosts")
	public ResponseEntity <List<PostDto>> getAllPosts(){
		
		List<PostDto> allPosts = service.getAllPosts();
		return new ResponseEntity<List<PostDto>>(allPosts, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> deletePosts(@PathVariable Integer id){
		
		service.DeletePost(id);
		String message = "Post data are : "+id+": successfully Deleted";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	
	
	@PutMapping("/updatePost/{id}")
	public ResponseEntity<PostDto> updatePosts(@RequestBody PostDto dto, @PathVariable Integer id){
		
		PostDto updatePost = service.updatePost(dto, id);
		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/getPostbycatid/{id}/posts")
	public ResponseEntity<List<PostDto>> getAllPostByCategoryIds(@PathVariable Integer id){
		
		List<PostDto> allPostByCategoryId = service.getAllPostByCategoryId(id);
		return new ResponseEntity<List<PostDto>>(allPostByCategoryId, HttpStatus.OK);
	}
	
	
	@GetMapping("/getPostsByUsingUserId/{id}/posts")
	public ResponseEntity<List<PostDto>> getALlPostsByUsingUserIds(@PathVariable Integer id){
		
		List<PostDto> allPostsByUserId = service.getAllPostsByUserId(id);
		return new ResponseEntity<List<PostDto>>(allPostsByUserId, HttpStatus.OK);
	}
	
	// 6 : 27 : 15
}
