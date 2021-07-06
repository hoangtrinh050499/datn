package webmypham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.ProductDTO;
import webmypham.DTO.SkintypeDTO;
import webmypham.convert.ProductConverter;
import webmypham.convert.SkintypeConvert;
import webmypham.model.Product_Skintype;
import webmypham.repository.ProductRipository;
import webmypham.repository.Product_SkintypeRepository;

@Service
public class Product_SkintypeService {


	@Autowired
	ProductConverter productconvert;
	@Autowired
	SkintypeConvert skintypeconvert;
	
	
	@Autowired
	Product_SkintypeRepository prodycProduct_SkintypeRepository;
	
	public List<Product_Skintype> getAll(int id){
		return prodycProduct_SkintypeRepository.findAll(id);
	}
	
	public List<Product_Skintype> getproducts(int id){
		return prodycProduct_SkintypeRepository.findprroducts(id);
	}
	
	public void save(ProductDTO pro) {
		
		for(SkintypeDTO i : pro.getSkintype()) {
			Product_Skintype pro_skin = new Product_Skintype();
			pro_skin.setProduct(productconvert.mapProductDtoToEntity(pro));
			pro_skin.setSkintype(skintypeconvert.mapSkintypeDtoToEntity(i));
			prodycProduct_SkintypeRepository.save(pro_skin);
		}
	}
	public void delete(int pro) {
		prodycProduct_SkintypeRepository.delete(pro);
		}
	
	
}
