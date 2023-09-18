package in.RahemanBlog.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.RahemanBlog.Entity.Category;
import in.RahemanBlog.Payloads.categoryDto;
import in.RahemanBlog.Repository.categoryRepo;
import in.RahemanBlog.Service.categoryService;
import in.RahemanBlog.sException.categoryException;

@Service
public class categoryServiceImpl implements categoryService {
	
	
	@Autowired
	private categoryRepo catRepo;
	
	@Autowired
	private ModelMapper mapper;

	
	@Override
	public categoryDto createCategory(categoryDto dto) {
		
		Category category = this.categoryDtoToCategory(dto);
		Category saveCategory = this.catRepo.save(category);
		
		return this.categoryToDto(saveCategory);
	}

	@Override
	public categoryDto getOneCategory(Integer id) {
		
		Category findCategory = catRepo.findById(id).orElseThrow(() -> new categoryException("That "+id+" Category Id Not Exists"));
		Category getCat = catRepo.save(findCategory);
		
		return categoryToDto(getCat);
	}

	@Override
	public List<categoryDto> getAllCategory() {
		
		List<Category> allCategory = catRepo.findAll();
		
		ArrayList<categoryDto> arrayList = new ArrayList<>();
		
		for(Category cats : allCategory) {
			arrayList.add(categoryToDto(cats));
		}
		return arrayList;
	}

	@Override
	public categoryDto updateCategory(categoryDto dto, Integer id) {
		
		Category update = catRepo.findById(id).orElseThrow(() -> new categoryException("That "+id+" Category Id Not Exists"));
		update.setCategoryTitle(dto.getCategoryTitle());
		update.setCategoryDescription(dto.getCategoryDescription());
		
		Category updateCat = catRepo.save(update);
		
		return categoryToDto(updateCat);
	}

	@Override
	public void deleteCategory(Integer id) {
         
		Category delete = catRepo.findById(id).orElseThrow(() -> new categoryException("That "+id+" Category Id Not Exists"));
		catRepo.delete(delete);
	}
	
	
	
	//category to dto
	 public categoryDto categoryToDto(Category cat){
		 
		 categoryDto mapper1 = mapper.map(cat, categoryDto.class);
		 return mapper1;
	 }
	
	 
	 //dto to category
	public Category categoryDtoToCategory(categoryDto dto){
		
		Category mapper2 = mapper.map(dto, Category.class);
		return mapper2;
	}

}
