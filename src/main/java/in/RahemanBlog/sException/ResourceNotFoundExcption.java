package in.RahemanBlog.sException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundExcption extends RuntimeException {

    String ResourceName;
	String fieldName;
	long fieldValue;
	
	
	public ResourceNotFoundExcption(String resourceName, String fieldName, long fieldValue) {
		
		super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue ));
		ResourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	
	
	
	
	
}
