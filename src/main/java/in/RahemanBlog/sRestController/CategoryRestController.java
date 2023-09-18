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

import in.RahemanBlog.Payloads.categoryDto;
import in.RahemanBlog.Service.categoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

	@Autowired
	private categoryService service;
	
	
	@PostMapping("/create")
	public ResponseEntity<categoryDto> createCategory(@Valid @RequestBody categoryDto dto){
		
		categoryDto createCategory = service.createCategory(dto);
		return new ResponseEntity<categoryDto>(createCategory, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<categoryDto> getOneCategory(@PathVariable Integer id){
		
		categoryDto oneCategory = service.getOneCategory(id);
		return new ResponseEntity<categoryDto>(oneCategory, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<categoryDto>> getAllCategory(){
		
		List<categoryDto> allCategory = service.getAllCategory();
		return new ResponseEntity<List<categoryDto>>(allCategory, HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<categoryDto> updateCategory(@Valid @RequestBody categoryDto dto, @PathVariable Integer id){
		
		categoryDto updateCategory = service.updateCategory(dto, id);
		return new ResponseEntity<categoryDto>(updateCategory, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
		
		service.deleteCategory(id);
		String message = "Category data "+id+" Deleted";
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
