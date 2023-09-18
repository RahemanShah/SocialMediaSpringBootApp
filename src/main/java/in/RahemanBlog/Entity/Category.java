package in.RahemanBlog.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	
	@Column(length = 100, nullable = false)
	private String categoryTitle;
	
	@Column(length = 100)
	private String categoryDescription;
	
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> posts = new ArrayList<>();
	
	
	
	
	/*
	  1 category having multiple post
	  if post is multiple then take post in List<Post> 
	*/
	
	
	/*
	 (mappedBy = "category"); that category should be match with 
	 
	 @ManyToOne
	  private Category category;    , that category which is available in post entity class
	 
	 
	*/
}
