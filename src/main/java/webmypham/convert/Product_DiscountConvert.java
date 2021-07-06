package webmypham.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webmypham.DTO.DiscountDTO;
import webmypham.DTO.ProductDTO;
import webmypham.DTO.Product_DiscountDTO;
import webmypham.model.Discount;
import webmypham.model.Product_Discount;

@Component
public class Product_DiscountConvert {
	
	@Autowired
	ProductConverter productconvert;
	
	
	public DiscountDTO mapDiscountEntityToDto(Discount discount) {
		DiscountDTO discountdto = new DiscountDTO();
		discountdto.setId(discount.getId());
		discountdto.setLevel(discount.getLevel());
		return discountdto;
	}
	
	public Discount mapDiscountDtoToEntity(DiscountDTO discountdto) {
		Discount discount = new Discount();
		discount.setId(discountdto.getId());
		discount.setLevel(discountdto.getLevel());
		return discount;
	}
	
	
	public Product_DiscountDTO mapProduct_DiscountEntityToDto(Product_Discount discount,ProductDTO productdto) {
		Product_DiscountDTO discountdto = new Product_DiscountDTO();
		discountdto.setId(discount.getId());
		discountdto.setDiscount(mapDiscountEntityToDto(discount.getDiscount()));
		discountdto.setProducts(productdto);
		discountdto.setStart(discount.getStart());
		discountdto.setEnd(discount.getEnd());
		return discountdto;
	}
	
	public Product_Discount mapProduct_DiscountDtoToEntity(Product_DiscountDTO discountdto) {
		Product_Discount discount = new Product_Discount();
		discount.setId(discount.getId());
		discount.setDiscount(mapDiscountDtoToEntity(discountdto.getDiscount()));
		discount.setProducts(productconvert.mapProductDtoToEntity(discountdto.getProducts()));
		discount.setStart(discountdto.getStart());
		discount.setEnd(discountdto.getEnd());
		return discount;
	}
	
	
	
	

}
