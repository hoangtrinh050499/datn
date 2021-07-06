package webmypham.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.CategoryDTO;
import webmypham.DTO.CompositionDTO;
import webmypham.DTO.ImageproductDTO;
import webmypham.DTO.ProductDTO;
import webmypham.DTO.SkintypeDTO;
import webmypham.DTO.TrademarkDTO;
import webmypham.convert.CategoryConvert;
import webmypham.convert.CompositionConvert;
import webmypham.convert.ImageproductConvert;
import webmypham.convert.ProductConverter;
import webmypham.convert.SkintypeConvert;
import webmypham.convert.TrademarkConvert;
import webmypham.model.CategoryTitle;
import webmypham.model.ImageProduct;
import webmypham.model.Product_Composition;
import webmypham.model.Product_Skintype;
import webmypham.model.Products;
import webmypham.model.Trademark;
import webmypham.model.product_category;
import webmypham.repository.Product_CategoryRepository;
import webmypham.repository.TrademarkRipository;

@Service
public class TrademarkService {

	@Autowired
	TrademarkConvert TrademarkConvert;
	@Autowired
	private TrademarkRipository trademarkRipository;
	@Autowired
	ProductService productService;
	@Autowired
	CatogorytitleService cateCatogorytitleService;
	@Autowired
	ImportdetailService importdetailService;
	@Autowired
	Product_CompositionService product_CompositionService;
	@Autowired
	CompositionConvert compositionconvert;
	@Autowired
	TrademarkConvert trademarkconvert;
	@Autowired
	Product_CategoryService product_CategoryService;
	@Autowired
	CategoryConvert categoryconvert;
	@Autowired
	Product_SkintypeService product_SkintypeService;
	@Autowired
	SkintypeConvert skintypeconvert;
	@Autowired
	ImageService imageService;
	@Autowired
	ImageproductConvert imageconvert;
	@Autowired
	ProductConverter productconvert;
	@Autowired
	Product_DiscountService product_discountService;
	
	
	
	
	
	public List<TrademarkDTO> findAll(){
		List<TrademarkDTO> trademarkDTOs = new ArrayList<TrademarkDTO>();
		for(Trademark i : trademarkRipository.findAll()) {
			trademarkDTOs.add(TrademarkConvert.mapTrademarkEntityToDto(i));
		}
		return trademarkDTOs;
	}
	
	public void save(TrademarkDTO tdm) {
		trademarkRipository.save(TrademarkConvert.mapTrademarkDtoToEntity(tdm));
	}
	public TrademarkDTO findOne(int id) {
		return TrademarkConvert.mapTrademarkEntityToDto(trademarkRipository.findOne(id));
	}
	
	public void delete(int id) {
		trademarkRipository.delete(id);
	}
	
	public List<ProductDTO> getproducts(int id){
		List<ProductDTO> listproductdto = new ArrayList<ProductDTO>();
		
		List<Products> products = productService.getproducts(id);
		int price=0;
		int discount=0;
		for(Products pro : products) {
			
			ProductDTO productdto = new ProductDTO();
			TrademarkDTO trademarkDTO = new TrademarkDTO();
			List<CompositionDTO> listcompositiondto = new ArrayList<CompositionDTO>();
			CategoryDTO listcategorydto = new CategoryDTO();
			List<SkintypeDTO> listskintypedto = new ArrayList<SkintypeDTO>();
			List<String> listimage = new ArrayList<String>();
//			price = importdetailService.findprice(pro.getId());
			
			if(importdetailService.findprice(pro.getId())!=null){
				price = importdetailService.findprice(pro.getId());
			}
			else {
				price=0;
			}
			
//			discount = productRipository.finddiscount(pro.getId());
			if(product_discountService.discount(pro.getId()) !=  null) {
				discount = product_discountService.discount(pro.getId());
			}
			else {
				discount=0;
			}
			List<Product_Composition> product_composition = new ArrayList<Product_Composition>();
			product_composition = product_CompositionService.getidProduct(pro.getId());
			for(Product_Composition i : product_composition) {
				listcompositiondto.add(compositionconvert.mapCompositionEntityToDto( i.getComposition()));
			}
//			Trademark tra = pro.getTrademark();
//			trademarkDTO = trademarkconvert.mapTrademarkEntityToDto(tra);

			
//			List<product_category> product_categoryn = new ArrayList<product_category>();
//			product_categoryn = product_CategoryService.getAll(pro.getId());
//			for(product_category i : product_categoryn) {
//				CategoryTitle cate = cateCatogorytitleService.findOne(i.getCategory().getId());
//				listcategorydto.add(categoryconvert.mapCategoryEntityToDto( i.getCategory(),cate));
//			}
			
//			CategoryTitle cate = cateCatogorytitleService.findOne(pro.getCategory().getIdtitlecategory());
//			listcategorydto = categoryconvert.mapCategoryEntityToDto(pro.getCategory(),cate);
			
			
			List<Product_Skintype> product_Skintypes = new ArrayList<Product_Skintype>();
			product_Skintypes = product_SkintypeService.getAll(pro.getId());
			for(Product_Skintype i : product_Skintypes) {		
				listskintypedto.add(skintypeconvert.mapSkintypeEntityToDto(i.getSkintype()));
			}
			
			List<ImageProduct> imageProduct = new ArrayList<ImageProduct>();
			imageProduct = imageService.getProduct(pro);
			for(ImageProduct i : imageProduct) {
				listimage.add(i.getImage());
			}
			
			listproductdto.add(productconvert.mapProductEntityToDto( pro,price,discount ,listcompositiondto,
				 listskintypedto, listimage));

		}
		return listproductdto;
	}
	
}
