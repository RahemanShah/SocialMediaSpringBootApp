package in.RahemanBlog.Payloads;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Integer postId;
	
	private String title;
	
	private String content;
	
	private Date addedDate;
	
	private String imageName;
	
	private categoryDto category;   //it should be category dto, because there is no post are available in catDto class
	 
	private UserDto user;           //it should be user dto, because there is no post are available in UserDto class
	
	
}
