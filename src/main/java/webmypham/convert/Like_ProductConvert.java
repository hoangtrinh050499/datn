package webmypham.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webmypham.DTO.Like_ProductDTO;
import webmypham.DTO.ProductDTO;
import webmypham.model.Account;
import webmypham.model.Like_Product;

@Component
public class Like_ProductConvert {

	@Autowired
	ProductConverter productConvert;
	@Autowired
	AccountConvert accountConvert;
	
	public Like_ProductDTO mapLike_ProductEntityToDto(Like_Product like,ProductDTO prodto) {
		Like_ProductDTO likedto = new Like_ProductDTO();
		
		try {
			likedto.setId(like.getId());
		} catch (Exception e) {
		}
		likedto.setProducts(prodto);
		likedto.setAcount(accountConvert.mapAccountEntityToDto(like.getAcount()));
		return likedto;
	}
	
	public Like_Product mapLike_ProductDtoToEntity(Like_ProductDTO likedto) {
		Like_Product like = new Like_Product();
		like.setId(likedto.getId());
		like.setProducts(productConvert.mapProductDtoToEntity(likedto.getProducts()));
		like.setAcount(accountConvert.mapAccountDtoToEntity(likedto.getAcount()));
		return like;
	}
	
	
}
