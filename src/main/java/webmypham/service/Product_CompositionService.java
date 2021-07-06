package webmypham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.CompositionDTO;
import webmypham.DTO.ProductDTO;
import webmypham.convert.CompositionConvert;
import webmypham.convert.ProductConverter;
import webmypham.model.Composition;
import webmypham.model.Product_Composition;
import webmypham.model.Products;
import webmypham.repository.ProductRipository;
import webmypham.repository.Product_CompositionRepository;

@Service
public class Product_CompositionService {

	@Autowired
	ProductConverter productconvert;
	@Autowired
	CompositionConvert compositionconvert;
	
	@Autowired
	private Product_CompositionRepository product_CompositionRepository;
	
	public List<Product_Composition> getidProduct(int id){
		return product_CompositionRepository.findAll(id);
	}
	
	public List<Product_Composition> getidProducts(int id){
		return product_CompositionRepository.findAllproducts(id);
	}
	
	
	public void save(ProductDTO pro) {
		
		for(CompositionDTO i : pro.getComposition()) {
			Product_Composition pro_com = new Product_Composition();
			pro_com.setProducts(productconvert.mapProductDtoToEntity(pro));
			pro_com.setComposition(compositionconvert.mapCompositionDtoToEntity(i));
			product_CompositionRepository.save(pro_com);
		}
	}
	
	public void delete(int pro) {
		product_CompositionRepository.delete(pro);
		}
	
	
}
