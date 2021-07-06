package webmypham.convert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webmypham.DTO.CategoryDTO;
import webmypham.DTO.CompositionDTO;
import webmypham.DTO.ImageproductDTO;
import webmypham.DTO.ProductDTO;
import webmypham.DTO.ProductclassDTO;
import webmypham.DTO.SkintypeDTO;
import webmypham.DTO.TrademarkDTO;
import webmypham.model.Category;
import webmypham.model.Composition;
import webmypham.model.ImageProduct;
import webmypham.model.Products;
import webmypham.model.Skintype;
import webmypham.model.Trademark;

@Component
public class ProductConverter {
	@Autowired
	TrademarkConvert trademarkConvert;
	@Autowired
	CategoryConvert categoryconvert;;
	
	public ProductDTO mapProductEntityToDto(Products product,int price,int discount
		,List<CompositionDTO> composition,
			List<SkintypeDTO> skintype, List<String> imageproduct) {
	
		ProductDTO productdto = new ProductDTO();
		productdto.setId(product.getId());
		productdto.setNameproduct(product.getNameproduct());
		productdto.setImage(product.getImage());
		productdto.setIntroduce(product.getIntroduce());
		productdto.setOverview(product.getOverview());
		productdto.setDetailcomposition(product.getDetailcomposition());
		productdto.setUses(product.getUses());
		productdto.setBarcode(product.getBarcode());
		productdto.setDiscount(discount);
		productdto.setPrice(price);
		productdto.setComposition(composition);
		productdto.setTrademark(trademarkConvert.mapTrademarkEntityToDto(product.getTrademark()));
		productdto.setCategory(categoryconvert.mapCategoryEntityToDto(product.getCategory()));
		productdto.setSkintype(skintype);
		productdto.setImageproduct(imageproduct);
		return productdto;
	}
	
	public Products mapProductDtoToEntity(ProductDTO productdto) {
		Products product = new Products();
		if(productdto != null) {
			product.setId(productdto.getId());
			product.setNameproduct(productdto.getNameproduct());
			product.setImage(productdto.getImage());
			product.setIntroduce(productdto.getIntroduce());
			product.setOverview(productdto.getOverview());
			product.setDetailcomposition(productdto.getDetailcomposition());
			product.setUses(productdto.getUses());
			product.setBarcode(productdto.getBarcode());
			product.setCategory(categoryconvert.mapCategoryDtoToEntity(productdto.getCategory()));
			product.setTrademark(trademarkConvert.mapTrademarkDtoToEntity(productdto.getTrademark()));
			return product;
		}
		return null;
		
	}
	
	public ProductclassDTO mapProductclassEntityToDto(Products pro) {
		ProductclassDTO prodto = new ProductclassDTO();
		prodto.setId(pro.getId());
		prodto.setNameproduct(pro.getNameproduct());
		prodto.setImage(pro.getImage());
		prodto.setIntroduce(pro.getIntroduce());
		prodto.setOverview(pro.getOverview());
		prodto.setDetailcomposition(pro.getDetailcomposition());
		prodto.setUses(pro.getUses());
		prodto.setBarcode(pro.getBarcode());
		prodto.setCategory(categoryconvert.mapCategoryEntityToDto(pro.getCategory()));
		pro.setTrademark(pro.getTrademark());
		return prodto;
	}

	public Products mapProductclassDtoToEntity(ProductclassDTO pro) {
		Products prodto = new Products();
		prodto.setId(pro.getId());
		prodto.setNameproduct(pro.getNameproduct());
		prodto.setImage(pro.getImage());
		prodto.setIntroduce(pro.getIntroduce());
		prodto.setOverview(pro.getOverview());
		prodto.setDetailcomposition(pro.getDetailcomposition());
		prodto.setUses(pro.getUses());
		prodto.setBarcode(pro.getBarcode());
		prodto.setCategory(categoryconvert.mapCategoryDtoToEntity(pro.getCategory()));
		pro.setTrademark(pro.getTrademark());
		return prodto;
	}
	
	

}
