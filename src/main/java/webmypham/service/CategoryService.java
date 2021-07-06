package webmypham.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.CategoryDTO;
import webmypham.DTO.CompositionDTO;
import webmypham.DTO.ImageproductDTO;
import webmypham.DTO.ProductDTO;
import webmypham.DTO.SkintypeDTO;
import webmypham.DTO.TrademarkDTO;
import webmypham.convert.CategoryConvert;
import webmypham.convert.CompositionConvert;
import webmypham.convert.ImageproductConvert;
import webmypham.convert.ProductConverter;
import webmypham.convert.SkintypeConvert;
import webmypham.convert.TrademarkConvert;
import webmypham.model.Category;
import webmypham.model.CategoryTitle;
import webmypham.model.ImageProduct;
import webmypham.model.Product_Composition;
import webmypham.model.Product_Skintype;
import webmypham.model.Products;
import webmypham.model.Trademark;
import webmypham.model.product_category;
import webmypham.repository.CategoryRipository;
import webmypham.repository.Product_CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryConvert categoryConvert;
	@Autowired
	private CategoryRipository categoryRipository;
	@Autowired
	CatogorytitleService cateCatogorytitleService;
	@Autowired
	Product_CategoryRepository product_CategoryRepository;
	@Autowired
	ImportdetailService importdetailService;
	@Autowired
	Product_CompositionService product_CompositionService;
	@Autowired
	CompositionConvert compositionconvert;
	@Autowired
	TrademarkConvert trademarkconvert;
	@Autowired
	Product_CategoryService product_CategoryService;
	@Autowired
	CategoryConvert categoryconvert;
	@Autowired
	Product_SkintypeService product_SkintypeService;
	@Autowired
	SkintypeConvert skintypeconvert;
	@Autowired
	ImageService imageService;
	@Autowired
	ImageproductConvert imageconvert;
	@Autowired
	ProductConverter productconvert;
	@Autowired
	ProductService productService;
	
	
	
	public List<CategoryDTO> findAll(){
		List<CategoryDTO> categoryDTO = new ArrayList<CategoryDTO>();
		for(Category i : categoryRipository.findAll()) {
//			CategoryTitle cate = cateCatogorytitleService.findOne(i.getIdtitlecategory());
			categoryDTO.add(categoryConvert.mapCategoryEntityToDto(i));
		}
		return categoryDTO;
	}
	
	public CategoryDTO findOne(int id) {
		Category category = categoryRipository.findOne(id);
//		CategoryTitle cate = cateCatogorytitleService.findOne(category.getIdtitlecategory());
		return categoryConvert.mapCategoryEntityToDto(category);
	}
	
	public void save(CategoryDTO category) {
		categoryRipository.save(categoryConvert.mapCategoryDtoToEntity(category));
	}
	public void delete(int id) {
		categoryRipository.delete(id);
	}
	
	public List<ProductDTO> getproducts(int id){
		return productService.findAllcategory(id);
	}
	
	public List<CategoryDTO> getCategory(int id){
		List<CategoryDTO> list = new ArrayList<CategoryDTO>();
		for (Category  category : categoryRipository.getCategory(id)) {
			list.add(categoryConvert.mapCategoryEntityToDto(category));
		}
		return list;
	}

}
