package in.RahemanBlog.sException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundExcption.class)
	public ResponseEntity<?> handelingException(ResourceNotFoundExcption e){
		
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		HashMap<String, String> map = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach( (error) ->{
			
			String fieldName = ((FieldError)error).getField();
			String defaultMessage = error.getDefaultMessage();
			
			map.put(fieldName, defaultMessage);
		});
		
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(categoryException.class)
	public ResponseEntity<?> handelingCategoryException(categoryException ex){
		
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	/*
	 
	 
	 public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
	 
     BindingResult bindingResult = ex.getBindingResult();
     
     List<FieldError> fieldErrors = bindingResult.getFieldErrors();
    
     HashMap<String, String> map = new HashMap<>(fieldErrors.size());


    for (FieldError fieldError : fieldErrors) {
        map.put(fieldError.getField(), fieldError.getDefaultMessage());
    }

    return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
}

In this version, I've minimized line usage by combining variable declarations and assignments and removed any unnecessary whitespace. However, it still does not use Java 8 features, as requested.






	
	 
	*/
}
