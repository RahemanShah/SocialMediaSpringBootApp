package in.RahemanBlog.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.RahemanBlog.Entity.User;
import in.RahemanBlog.Payloads.UserDto;
import in.RahemanBlog.Repository.UserRepo;
import in.RahemanBlog.Service.UserService;
import in.RahemanBlog.sException.ResourceNotFoundExcption;

@Service
public class UserSerice_Impl implements UserService {

	
	
	@Autowired
	private UserRepo uRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	// 2:40:00  durgesh get error in getOneUser
	/*
	 
	 u created method of userDto, and passed userDto parameter,
	 Take First User Data meanse ur return should be (user) and Check that method and get that method  ,
	 then save that user return in repo.save and get some retun of save method,
	 and take another method and in another method pass that save method return that set  (dont forgot to pass this)
	 
	*/
	
	@Override
	public UserDto createUser(UserDto udto) {
		
		User user = this.DtoToUser(udto);
		User saveUser = this.uRepo.save(user);
		
		return this.userToDto(saveUser);
		
	}

	
	
	@Override
	public UserDto updateUser(UserDto udto, Integer id) {
		
		User user = uRepo.findById(id).orElseThrow( ()-> new ResourceNotFoundExcption("User","Id",id));
		
		//user.setId(udto.getId());  u can not update id dont take id to update
		user.setName(udto.getName());
		user.setEmail(udto.getEmail());
		user.setPassword(udto.getPassword());
		user.setAbout(udto.getAbout());
		
		User updates = this.uRepo.save(user);
		UserDto userToDto = this.userToDto(updates);
		
		return userToDto;
		
	}

	@Override
	public UserDto getUserById(Integer id) {
		
		User User = this.uRepo.findById(id).orElseThrow( ()-> new ResourceNotFoundExcption("User", "Id", id));
		
	    User saveUser = this.uRepo.save(User);
		
		return this.userToDto(saveUser);
	}

	
	
	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> getAllUser = uRepo.findAll();
		
		ArrayList<UserDto> dtoArraylist = new ArrayList<>();
		
		for(User userData : getAllUser) {
			dtoArraylist.add(userToDto(userData));
		}
		
		return dtoArraylist;
	}
	
	

	@Override
	public void deleteUser(Integer id) {
          
		User user = uRepo.findById(id).orElseThrow( ()-> new ResourceNotFoundExcption("User", "Id", id) );
		
		uRepo.delete(user);
	}
	
		/*
		 
		 u used delete method because return type is user and user is a class ,
		 unlike its not return id to use deleteById
		
		 if return id then use deleteyId;
		 if return User class object then use delete method
		
		*/
	
	// ---------------------------------------------------------------------------------
	

	/*
	   userDto to user 
	   Whenever u r creating userDto to User then ur return should be User and parameter must be userDto
	*/
	
	
	
/*
	public User DtoToUser(UserDto uDto) {
		
		User user = new User();
		
		user.setId(uDto.getId());
		user.setName(uDto.getName());
		user.setEmail(uDto.getEmail());
		user.setAbout(uDto.getAbout());
		user.setPassword(uDto.getPassword());
		
		return user;
	}
	
*/
	
	
    /*
       User to userDto
       Whenever u r creating User to UserDto then ur return should be UserDto and parameter must be User
    */
	
	
/*
    public UserDto userToDto(User user) {
    	
    	UserDto userDto = new UserDto();
    	
    	userDto.setId(user.getId());
    	userDto.setName(user.getName());
    	userDto.setEmail(user.getEmail());
    	userDto.setPassword(user.getPassword());
    	userDto.setAbout(user.getAbout());
    	
    	return userDto;
    }
*/
	
	
	public User DtoToUser(UserDto uDto) {
		
		User user = mapper.map(uDto, User.class);
		return user;
	}
	
	public UserDto userToDto(User user) {
		
		UserDto userDt = mapper.map(user, UserDto.class);
		return userDt;
	}
}
