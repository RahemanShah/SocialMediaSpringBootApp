package in.RahemanBlog.sRestController;

import java.util.List;

import javax.validation.Valid;

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

import in.RahemanBlog.Payloads.UserDto;
import in.RahemanBlog.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserService service;
	
	//u used @valid annotation for validation its must be there
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto udto){
		
		UserDto createUser = service.createUser(udto);
		return new ResponseEntity<UserDto>(createUser, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto dto, @PathVariable Integer id){
		
		UserDto updateUser = this.service.updateUser(dto, id);
		return ResponseEntity.ok(updateUser);
	}

	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<UserDto> getOneUser(@PathVariable Integer id){
		
		UserDto userById = service.getUserById(id);
		return new ResponseEntity<UserDto>(userById, HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity <List<UserDto>> getAllUser(){
		
		List<UserDto> allUsers = service.getAllUsers();
		return new ResponseEntity<List<UserDto>>(allUsers, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id){
		
		String message = "User "+id+"Deleted";
		service.deleteUser(id);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
}
