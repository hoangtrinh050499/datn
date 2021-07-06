package webmypham.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.Like_ProductDTO;
import webmypham.convert.Like_ProductConvert;
import webmypham.model.Like_Product;
import webmypham.repository.Like_ProductRepository;

@Service
public class Like_ProductService {

	@Autowired
	Like_ProductRepository like_productRepository;
	@Autowired
	Like_ProductConvert like_productconvert;
	
	public void save(Like_ProductDTO like) {
		like_productRepository.save(like_productconvert.mapLike_ProductDtoToEntity(like));
	}
	
	public List<Like_ProductDTO> findAll(){
		List<Like_ProductDTO> list = new ArrayList<Like_ProductDTO>();
//		for (Like_Product like_Product : like_productRepository.findAll()) {
//			list.add(like_productconvert.mapLike_ProductEntityToDto(like_Product));
//		}
		return list;
	}
	
	public int findcocunt(int id) {
		return like_productRepository.findcount(id);
	}
	
	
}
