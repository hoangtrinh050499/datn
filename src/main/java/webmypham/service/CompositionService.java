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
import webmypham.model.Category;
import webmypham.model.CategoryTitle;
import webmypham.model.Composition;
import webmypham.model.ImageProduct;
import webmypham.model.Product_Composition;
import webmypham.model.Product_Skintype;
import webmypham.model.Trademark;
import webmypham.model.product_category;
import webmypham.repository.CompositionRepository;

@Service
public class CompositionService {
	
	@Autowired
	CompositionConvert compositionConvert;

	@Autowired
	private CompositionRepository compositionRepository;
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
	CatogorytitleService cateCatogorytitleService;
	@Autowired
	Product_DiscountService product_discountService;
	
	
	
	
	public List<CompositionDTO> findAll(){
		List<CompositionDTO> comdto= new ArrayList<CompositionDTO>();
		for(Composition com : compositionRepository.findAll()) {
			comdto.add(compositionConvert.mapCompositionEntityToDto(com));
		}
		
		return comdto;
	}
	
	public CompositionDTO findOne(int id) {
		return compositionConvert.mapCompositionEntityToDto(compositionRepository.findOne(id));
	}
	
	public void save(Composition composition) {
		compositionRepository.save(composition);
	}
	public void delete(int id) {
		compositionRepository.delete(id);
	}
	
	
	public List<ProductDTO> getproducts(int id){
		List<ProductDTO> listproductdto = new ArrayList<ProductDTO>();
		
		List<Product_Composition> products = product_CompositionService.getidProducts(id);
		int price=0;
		int discount=0;
		for(Product_Composition pro : products) {
			
			ProductDTO productdto = new ProductDTO();
			TrademarkDTO trademarkDTO = new TrademarkDTO();
			List<CompositionDTO> listcompositiondto = new ArrayList<CompositionDTO>();
			CategoryDTO listcategorydto = new CategoryDTO();
			List<SkintypeDTO> listskintypedto = new ArrayList<SkintypeDTO>();
			List<String> listimage = new ArrayList<String>();
			
//			discount = productRipository.finddiscount(pro.getId());
			
			if(importdetailService.findprice(pro.getProducts().getId())!=null){
				price = importdetailService.findprice(pro.getProducts().getId());
			}
			else {
				price=0;
			}
			
			
			if(product_discountService.discount(pro.getProducts().getId())!=null) {
				discount = product_discountService.discount(pro.getProducts().getId());
			}
			else {
				discount=0;
			}
			List<Product_Composition> product_composition = new ArrayList<Product_Composition>();
			product_composition = product_CompositionService.getidProduct(pro.getProducts().getId());
			for(Product_Composition i : product_composition) {
				listcompositiondto.add(compositionconvert.mapCompositionEntityToDto( i.getComposition()));
			}
//			Trademark tra = pro.getProducts().getTrademark();
//			trademarkDTO = trademarkconvert.mapTrademarkEntityToDto(tra);

			
//			List<product_category> product_categoryn = new ArrayList<product_category>();
//			product_categoryn = product_CategoryService.getAll(pro.getId());
//			for(product_category i : product_categoryn) {
//				CategoryTitle cate = cateCatogorytitleService.findOne(i.getCategory().getId());
//				listcategorydto.add(categoryconvert.mapCategoryEntityToDto( i.getCategory(),cate));
//			}
//			CategoryTitle cate = cateCatogorytitleService.findOne(pro.getProducts().getCategory().getIdtitlecategory());
//			listcategorydto = categoryconvert.mapCategoryEntityToDto(pro.getProducts().getCategory(),cate);
			
			
			
			List<Product_Skintype> product_Skintypes = new ArrayList<Product_Skintype>();
			product_Skintypes = product_SkintypeService.getAll(pro.getId());
			for(Product_Skintype i : product_Skintypes) {		
				listskintypedto.add(skintypeconvert.mapSkintypeEntityToDto(i.getSkintype()));
			}
			
			List<ImageProduct> imageProduct = new ArrayList<ImageProduct>();
			imageProduct = imageService.getProduct(pro.getProducts());
			for(ImageProduct i : imageProduct) {
				listimage.add(i.getImage());
			}
			
			listproductdto.add(productconvert.mapProductEntityToDto( pro.getProducts(),price,discount ,listcompositiondto,
					 listskintypedto, listimage));

		}
		return listproductdto;
	}
}
