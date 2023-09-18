package in.RahemanBlog.Service;

import java.util.List;

import in.RahemanBlog.Payloads.UserDto;

public interface UserService {

	public UserDto createUser(UserDto udto);
	
	public UserDto updateUser(UserDto udto, Integer id);
	
	public UserDto getUserById(Integer id);
	
	public List<UserDto> getAllUsers();
	
	public void deleteUser(Integer id);
}
