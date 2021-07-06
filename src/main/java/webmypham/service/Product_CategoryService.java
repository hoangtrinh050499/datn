package webmypham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.CategoryDTO;
import webmypham.DTO.ProductDTO;
import webmypham.convert.CategoryConvert;
import webmypham.convert.ProductConverter;
import webmypham.model.Product_Composition;
import webmypham.model.product_category;
import webmypham.repository.ProductRipository;
import webmypham.repository.Product_CategoryRepository;
import webmypham.repository.Product_CompositionRepository;

@Service
public class Product_CategoryService {
	@Autowired
	ProductConverter productconvert;
	@Autowired
	CategoryConvert categoryconvert;

	@Autowired
	private Product_CategoryRepository product_CategoryRepository;
	
	public List<product_category> getAll(int id){
		return product_CategoryRepository.findAll(id);
	}
	
	public List<product_category> getcategory(int id){
		return product_CategoryRepository.findcategory(id);
	}
	
//	public void save(ProductDTO pro) {
//		
//		for(CategoryDTO i : pro.getCategory()) {
//			product_category pro_cate = new product_category();
//			pro_cate.setProduct(productconvert.mapProductDtoToEntity(pro));
//			pro_cate.setCategory(categoryconvert.mapCategoryDtoToEntity(i));
//			product_CategoryRepository.save(pro_cate);
//		}
//	}
	
}
