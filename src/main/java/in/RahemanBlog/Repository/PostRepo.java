package in.RahemanBlog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.RahemanBlog.Entity.Category;
import in.RahemanBlog.Entity.Post;
import in.RahemanBlog.Entity.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	public List<Post> findByUser(User user);
	
	public List<Post> findByCategory(Category category);
	
}

