package in.RahemanBlog.Payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class categoryDto {

	private Integer categoryId;
	
	@NotBlank
	@Size(min = 4, message = "category title more that 4 charector")
	private String categoryTitle;
	
	@NotBlank
	@Size(min = 10, message = "Category Description more than 10 charector")
	private String categoryDescription;
}
