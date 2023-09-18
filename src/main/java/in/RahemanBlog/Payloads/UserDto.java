package in.RahemanBlog.Payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private int id;
	
	@NotNull
	@Size(min = 3, message = "Name must be greater than 3 charector")
	private String name;
	
	@Email(message = "Email address not valid")
	private String email;
	
	@NotNull
	@Size(min = 3, message = "password must be min 3 to 8 charector")
	private String password;
	
	@NotNull
	private String about;
}
