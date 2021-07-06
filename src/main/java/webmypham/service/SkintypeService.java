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
import webmypham.model.Skintype;
import webmypham.model.Trademark;
import webmypham.model.product_category;
import webmypham.repository.Product_SkintypeRepository;
import webmypham.repository.SkintypeRipository;

@Service
public class SkintypeService {
	
	@Autowired
	SkintypeConvert skintypeConvert;

	@Autowired
	private SkintypeRipository skintypeRipository;

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
	ImportdetailService importdetailService;
	
	@Autowired
	CatogorytitleService cateCatogorytitleService;
	
	@Autowired
	Product_DiscountService product_discountService;
	
	
	
	
	public SkintypeDTO findOne(int id) {
		return skintypeConvert.mapSkintypeEntityToDto(skintypeRipository.findOne(id));
	}
	
	public List<SkintypeDTO> findAll(){
		List<SkintypeDTO> list = new ArrayList<SkintypeDTO>();
		for(Skintype skin : skintypeRipository.findAll()) {
			list.add(skintypeConvert.mapSkintypeEntityToDto(skin));
		}
		return list;
	}
	
	public List<ProductDTO> getproducts(int id){
		List<ProductDTO> listproductdto = new ArrayList<ProductDTO>();
		
		List<Product_Skintype> products = product_SkintypeService.getproducts(id);
		int price=0;
		int discount=0;
		for(Product_Skintype pro : products) {
			
			ProductDTO productdto = new ProductDTO();
			TrademarkDTO trademarkDTO = new TrademarkDTO();
			List<CompositionDTO> listcompositiondto = new ArrayList<CompositionDTO>();
			CategoryDTO listcategorydto = new CategoryDTO();
			List<SkintypeDTO> listskintypedto = new ArrayList<SkintypeDTO>();
			List<String> listimage = new ArrayList<String>();
			
//			
			if(importdetailService.findprice(pro.getProduct().getId())!=null){
				price = importdetailService.findprice(pro.getProduct().getId());
			}
			else {
				price=0;
			}
			
			if(product_discountService.discount(pro.getProduct().getId()) !=  null) {
				discount = product_discountService.discount(pro.getProduct().getId());
			}
			else {
				discount=0;
			}
			
			List<Product_Composition> product_composition = new ArrayList<Product_Composition>();
			product_composition = product_CompositionService.getidProduct(pro.getId());
			for(Product_Composition i : product_composition) {
				listcompositiondto.add(compositionconvert.mapCompositionEntityToDto( i.getComposition()));
			}
//			Trademark tra = pro.getProduct().getTrademark();
//			trademarkDTO = trademarkconvert.mapTrademarkEntityToDto(tra);

			
//			List<product_category> product_categoryn = new ArrayList<product_category>();
//			product_categoryn = product_CategoryService.getAll(pro.getId());
//			for(product_category i : product_categoryn) {
//				CategoryTitle cate = cateCatogorytitleService.findOne(i.getCategory().getId());
//				listcategorydto.add(categoryconvert.mapCategoryEntityToDto( i.getCategory(),cate));
//			}
//			CategoryTitle cate = cateCatogorytitleService.findOne(pro.getProduct().getCategory().getIdtitlecategory());
//			listcategorydto = categoryconvert.mapCategoryEntityToDto(pro.getProduct().getCategory(),cate);
			
			
			List<Product_Skintype> product_Skintypes = new ArrayList<Product_Skintype>();
			product_Skintypes = product_SkintypeService.getAll(pro.getId());
			for(Product_Skintype i : product_Skintypes) {		
				listskintypedto.add(skintypeconvert.mapSkintypeEntityToDto(i.getSkintype()));
			}
			
			List<ImageProduct> imageProduct = new ArrayList<ImageProduct>();
			imageProduct = imageService.getProduct(pro.getProduct());
			for(ImageProduct i : imageProduct) {
				listimage.add(i.getImage());
			}
			
			listproductdto.add(productconvert.mapProductEntityToDto( pro.getProduct(),price,discount ,listcompositiondto,
					 listskintypedto, listimage));

		}
		return listproductdto;
	}
	
}
