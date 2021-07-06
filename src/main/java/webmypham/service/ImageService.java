package webmypham.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.ImageproductDTO;
import webmypham.DTO.ProductDTO;
import webmypham.convert.ImageproductConvert;
import webmypham.convert.ProductConverter;
import webmypham.model.ImageProduct;
import webmypham.model.Product_Skintype;
import webmypham.model.Products;
import webmypham.repository.ImageRipository;
import webmypham.repository.ProductRipository;

@Service
public class ImageService {
	
	
	@Autowired
	ProductConverter productconvert;
	@Autowired
	ImageproductConvert imageconvert;

	@Autowired
	ImageRipository imageRipository;
	
	public Iterable<ImageProduct> getAll(){
		return imageRipository.findAll();
	}
	
	
	public List<ImageProduct> getProduct(Products idProduct){
		return imageRipository.findByImageproduct(idProduct);
	}
	
	public void insert(ImageProduct img) {
		imageRipository.save(img);
	}
	
	public void save(ProductDTO pro) {
		
		for(String i : pro.getImageproduct()) {
			ImageProduct image = new ImageProduct();
			image.setIdproduct(productconvert.mapProductDtoToEntity(pro));
			image.setImage( i);
			
			imageRipository.save(image);
		}
	}
	
	public void delete(int pro) {
		imageRipository.delete(pro);
		}
	
	



	
}
