package in.RahemanBlog.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "POST")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	
	@Column(length = 100, nullable = false)
	private String title;
	
	@Column(length = 10000, nullable = false)
	private String content;

	private String imageName;
	
	private Date addedDate;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;   //post kis category ka hai, post kis ki hai usko category se filter karo
	                             // in 1 category we have multiple post
	@ManyToOne
	private User user;          // post kis user ka hai, which user uploaded post 
	
	
}
