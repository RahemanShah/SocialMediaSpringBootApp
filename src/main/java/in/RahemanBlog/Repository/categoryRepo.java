package in.RahemanBlog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.RahemanBlog.Entity.Category;

public interface categoryRepo extends JpaRepository<Category, Integer> {

}
