package in.RahemanBlog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.RahemanBlog.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
