package webmypham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import webmypham.model.ImageProduct;
import webmypham.model.Products;
import webmypham.service.ImageService;
import webmypham.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

	@Autowired
	ImageService imageService;
	
	@Autowired 
	ProductService productService;
	
	
//	@GetMapping(value="/image/one")
//	public ImageProduct getAll(@RequestBody Products id){
//		return imageService.findOne(id);
//	}

//	@GetMapping(value="/image/{id}")
//	public List<ImageProduct> getIdProduct(@PathVariable("id") int id){
//		Products pro = productService.findOne(id);
//		return (List<ImageProduct>) imageService.getProduct(pro);
//	}
	
//	@GetMapping(value="/image?idproduct= {id}")
//	public List<ImageProduct> getImageProduct(@RequestBody int id){
//		Products pro = productService.findOne(id);
//		return (List<ImageProduct>) imageService.getProduct(pro);
//	}
	
	
//	@PostMapping(value="/image/insert")
//	public String insert(ImageProduct ) {
//		
//	}
	
	
}
