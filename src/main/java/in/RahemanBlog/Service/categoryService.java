package in.RahemanBlog.Service;

import java.util.List;

import in.RahemanBlog.Payloads.categoryDto;

public interface categoryService {

	
	public categoryDto createCategory(categoryDto dto);
	
	public categoryDto getOneCategory(Integer id);
	
	public List<categoryDto> getAllCategory();
	
	public categoryDto updateCategory(categoryDto dto, Integer id);
	
	public void deleteCategory(Integer id);
}
