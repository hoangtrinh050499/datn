package webmypham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import webmypham.DTO.Like_ProductDTO;
import webmypham.service.Like_ProductService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Like_ProductController {

	@Autowired
	Like_ProductService like_productservice;
	
	@GetMapping(value="/get/like")
	public List<Like_ProductDTO> findAll(){
		return like_productservice.findAll();
	}
	
	@GetMapping(value="/get/likecount/{id}")
	public int findcount(@PathVariable("id")int id){
		return like_productservice.findcocunt(id);
	}
	
	@PostMapping(value="/insert/like")
	public void insert(@RequestBody Like_ProductDTO like) {
		like_productservice.save(like);
	}
	
	
}
